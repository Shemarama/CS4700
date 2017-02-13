#!/usr/bin/python2

# taken from https://rosettacode.org/wiki/Sorting_algorithms/Quicksort#Python
import time

def quicksort(array):
    _quicksort(array, 0, len(array)-1)
 
def _quicksort(array, start, end):
    if end - start > 0:
        pivot = array[start]
	left = start
	right = end
        while left <= right:
            while array[left] < pivot:
                left += 1
            while array[right] > pivot:
                right -= 1
            if left <= right:
                array[left], array[right] = array[right], array[left]
                left += 1
                right -= 1
        _quicksort(array, start, right)
        _quicksort(array, left, end)

def timeIt(f,n):
    s = time.time()
    f(n)
    e = (time.time()-s)*1000
    print 'Time: %f ms' % (e)


with open('../list.txt','r') as f:
    a = [ int(line.strip()) for line in f]
timeIt(quicksort,a)
