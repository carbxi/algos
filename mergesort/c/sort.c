#include <stdlib.h>
#include "sort.h"

static void merge(int *arr, int *buffer, int lo, int hi, int mid){
  int buffptr = 0;
  int loptr = lo;
  int hiptr = mid + 1;
  while(loptr <= mid && hiptr <= hi){
    if(arr[loptr] <= arr[hiptr]){
      buffer[buffptr] = arr[loptr];
      loptr++;
    } else{
      buffer[buffptr] = arr[hiptr];
      hiptr++;
    }
    buffptr++;
  }
  while(loptr <= mid){
    buffer[buffptr] = arr[loptr];
    loptr++;
  }
  while(hiptr <= hi){
    buffer[buffptr] = arr[hiptr];
    hiptr++;
  }
  for(int i = 0; i <= buffptr; i++){
    arr[lo + i] = buffer[i];
  }
}

static void mergeSortHelp(int *arr, int *buffer, int lo, int hi){
  if(lo >= hi)
    return;
  int mid = (lo + hi)/2;
  mergeSortHelp(arr, buffer, lo, mid);
  mergeSortHelp(arr, buffer, mid + 1, hi);
  merge(arr, buffer, lo, hi, mid);
}

void mergesort(int *arr, int len) {
  int *buffer = (int *)malloc(len * sizeof(int));
  mergeSortHelp(arr, buffer, 0, len - 1);
  free(buffer);
}
