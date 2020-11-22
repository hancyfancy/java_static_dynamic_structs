/*
BSD 3-Clause License

Copyright (c) 2020, hancyfancy
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.

3. Neither the name of the copyright holder nor the names of its
   contributors may be used to endorse or promote products derived from
   this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package corestructs;

import java.util.concurrent.RecursiveAction;

class ItemForkerJoiner<T extends Comparable<T>> extends RecursiveAction {
    private Item<?>[] array;
    private Item<?>[] aux;
    private int threadId;
    private int start;
    private int length;
    private int numberOfLeafThreads;
    protected ItemForkerJoiner(int newThreadId, Item<?>[] newArray, Item<?>[] newAux, int newNumberOfLeafThreads) {
        this.setThreadId(newThreadId);
        this.setArray(newArray);
        this.setAux(newAux);
        this.setNumberOfLeafThreads(newNumberOfLeafThreads);
    }
    protected Item<T>[] getArray() {
        return (Item<T>[])this.array;
    }
    protected void setArray(Item<?>[] newArray) {
        this.array = newArray;
    }
    protected Item<T>[] getAux() {
        return (Item<T>[])this.aux;
    }
    protected void setAux(Item<?>[] newAux) {
        this.aux = newAux;
    }
    protected int getThreadId() {
        return this.threadId;
    }
    protected void setThreadId(int newThreadId) {
        this.threadId = newThreadId;
    }
    protected int getStart() {
        return this.start;
    }
    protected void setStart(int newStart) {
        this.start = newStart;
    }
    protected int getLength() {
        return this.length;
    }
    protected void setLength(int newLength) {
        this.length = newLength;
    }
    protected int getNumberOfLeafThreads() {
        return this.numberOfLeafThreads;
    }
    protected void setNumberOfLeafThreads(int newNumberOfLeafThreads) {
        this.numberOfLeafThreads = newNumberOfLeafThreads;
    }
    private void sortSequentially(int threadId, Item<?>[] array, int numberOfLeafThreads) {
    	int blockSize = array.length / numberOfLeafThreads;
    	int firstLeafNode = numberOfLeafThreads; 
    	int lastNodeID = numberOfLeafThreads * 2 - 1;
    	int treeHeight = (int)(Math.log(lastNodeID)/Math.log(2));
    	int firstNodeOfLastLevel = (int)Math.pow(2, treeHeight);
    	int nodesInLastLevel = lastNodeID - firstNodeOfLastLevel + 1;
    	if (threadId >= firstNodeOfLastLevel) {
    		start = (threadId - firstNodeOfLastLevel) * blockSize;
        }
    	else {
    		start = (nodesInLastLevel + (threadId - firstLeafNode)) * blockSize;
    	}
    	length = blockSize;
    	if (checkPowerOfTwo(threadId + 1)) {
    		length = array.length - start;
    	}
        ItemDividerConquerer<?> dc = new ItemDividerConquerer<T>(array);
        setArray(dc.mergeSort(start, start+length-1));
    }
    @Override
    protected void compute() {
        int threadId = getThreadId();
        int numberOfLeafThreads = getNumberOfLeafThreads();
        Item<?>[] array = getArray();
        Item<?>[] aux = getAux();
        if (threadId >= numberOfLeafThreads) {
            sortSequentially(threadId, array, numberOfLeafThreads);
            return;
        }
        ItemForkerJoiner<?> th1 = new ItemForkerJoiner<T>(2*threadId, array, aux, numberOfLeafThreads);
        ItemForkerJoiner<?> th2 = new ItemForkerJoiner<T>(2*threadId+1, array, aux, numberOfLeafThreads);
        invokeAll(th1, th2);
        merge(array, aux, th1.getStart(), th2.getStart(), th2.getStart() + th2.getLength());
        setStart(th1.getStart());
        setLength(th1.getLength() + th2.getLength());
        //System.out.println("Thread id: ".concat(String.valueOf(threadId)).concat("\t\tstart index: ").concat(String.valueOf(start)).concat(" \t\tlength: ").concat(String.valueOf(length)));
    }
    private void merge(Item<?>[] d1, Item<?>[] aux, int start1, int start2, int last){
        int index1 = start1;
        int index2 = start2;
        int index3 = start1;
        while (index1 < start2 && index2 < last) {
            if (((Item<T>)d1[index1]).isLessThan((Item<T>)d1[index2])) {
                aux[index3] = d1[index1];
                index1++;
                index3++;
            } else {
                aux[index3] = d1[index2];
                index2++;
                index3++;
            }
        }
        while (index1 < start2) {
            aux[index3++] = d1[index1++];
        }
        while (index2 < last) {
            aux[index3++] = d1[index2++];
        }
        System.arraycopy(aux, start1, d1, start1, last-start1);
    }
    private boolean checkPowerOfTwo(int number) {
	    return ((number & (number - 1)) == 0);
  	}
}
