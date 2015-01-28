  //Sample routine with assert statements
  public void Build_Max_Heap(<T> A[])
   {
//Author:  			G Howser
//Purpose:  		Builds a Max Heap in A[] with root A[1]
//Heap_Test:		Returns "true" iff A[j] Max Heap for j, j+1, j+2, ... n
//
//Pre condition:	A[] is a non-empty array of integers
//Invariant:		A[j] is root of a Max Heap for j=i+1, i+2, ... n
    if (debug)
     {
      assert (((A[1] > 0) || (A[1] <= 0)));
     };
    int heap_size;
    int n = A.length - 1;
    heap_size = A.length - 1; //NOTE:  zero relative arrays but we are ignoring A[0]
    for (int i = Math.floor((n / 2.0)); i--; i < 1)
     {
      Max_Heapify(A, i);
      if (debug)
       {
        assert ((Heap_Test(A[], i));
       };
//Post condition:  A[] is a Max Heap
      if (debug)
       {
        assert ((Heap_Test(A[], 1));
       };
	 }