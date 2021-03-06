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

class Item<T extends Comparable<T>> implements Comparable<Item<T>>, IComparable<T> {
    private T content;
    public Item(T newContent) {
        this.setContent(newContent);
    }
    public T getContent() {
        return this.content;
    }
    private void setContent(T newContent) {
        if (newContent != getContent()) {
            this.content = newContent;
        }
    }
    public boolean equals(Object compareContent) {
        String thisContent = String.valueOf(getContent());
        String contentToCompare = String.valueOf((T)compareContent);
        return thisContent.equals(contentToCompare);
    }
    public int toInt() {
        return Integer.valueOf(toString());
    }
    public String toString() {
        return String.valueOf(getContent());
    }
    public Object toObject() {
        return (Object)getContent();
    }
    public int compareTo(Item<T> other) {
        return getContent().compareTo(other.getContent());
    }
    public boolean isLessThan(Item<T> rhs) {
        return compareTo(rhs) < 0;
    }
    public boolean isEqualTo(Item<T> rhs) {
        return compareTo(rhs) == 0;
    }
    public boolean isGreaterThan(Item<T> rhs) {
        return compareTo(rhs) > 0;
    }
    public boolean isLessThanOrEqualTo(Item<T> rhs) {
        return isLessThan(rhs) || isEqualTo(rhs);
    }
    public boolean isGreaterThanOrEqualTo(Item<T> rhs) {
        return isGreaterThan(rhs) || isEqualTo(rhs);
    }
}
