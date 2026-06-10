#include "sort.h"

static void swap(int *arr, int i, int j){
  int temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
}

static int partition(int *arr, int first, int last){
  int pivot = arr[last];
  int i = first;
  for(int j = i; j < last; j++){
    if(arr[j] < pivot) { swap(arr, i++, j); }
  }
  swap(arr, i, last);
  return i;
}

static void quickSortHelp(int *arr, int first, int last){
  if(first >= last){
    return;
  }
  int split = partition(arr, first, last);
  quickSortHelp(arr, first, split - 1);
  quickSortHelp(arr, split + 1, last);
}

void quickSort(int *arr, int len){
  quickSortHelp(arr, 0, len - 1);
}
