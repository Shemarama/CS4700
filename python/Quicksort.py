# taken from https://interactivepython.org/runestone/static/pythonds/SortSearch/TheQuickSort.html
def quickSort(a):
   quickSortHelper(a,0,len(a)-1)

def quickSortHelper(a,first,last):
   if first<last:

       pivot = partition(a,first,last)

       quickSortHelper(a,first,pivot-1)
       quickSortHelper(a,pivot+1,last)


def partition(a,first,last):
   pivotvalue = a[first]

   leftmark = first+1
   rightmark = last

   done = False
   while not done:

       while leftmark <= rightmark and a[leftmark] <= pivotvalue:
           leftmark = leftmark + 1

       while a[rightmark] >= pivotvalue and rightmark >= leftmark:
           rightmark = rightmark -1

       if rightmark < leftmark:
           done = True
       else:
           temp = a[leftmark]
           a[leftmark] = a[rightmark]
           a[rightmark] = temp

   temp = a[first]
   a[first] = a[rightmark]
   a[rightmark] = temp


   return rightmark

alist = [54,26,93,17,77,31,44,55,20]
quickSort(alist)
print(alist)
