Java的多关键字排序，可以通过让排序对象继承Comparable接口来实现；这样就可以定义排序对象之间的偏序关系。  
继承完了之后重写compareTo() 方法，排序的时候直接Arrays.sort()就行了。
