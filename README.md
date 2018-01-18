# LinearLayoutAdapter
适用于给LinearLayout进行增、删、改、查itemView的adapter

#### 适用场景：

少量的添加item View，同时不适合适用ListView的情况下

比如少量的item View外面嵌套有ScrollView，同时对item进行增、删、改、查操作

增：增加一条item，目前只支持在最下面添加

删：删除指定位置的任意一条item

改：更新数据，指定范围内的数据，从头开始更新数据，长度为0-所要更新数据的长度

查：获取LinearLayout添加的item View对应的数据信息

支持多种type的item的操作

> 多种type

在使用多种type的item时，建议在数据源中设置type类型，根据类型加载不同的View

#### 缺点：

该使用场景比较单一，没有listView的缓存策略，不存在复用机制，因此建议少量的添加item View

使用的数据结构比较单一，目前仅支持List集合，因此在使用时，可以将源码复制下来进行相应的修改

具体的逻辑在
[adapter文件下](https://github.com/ZGaoFei/LinearLayoutAdapter/tree/master/app/src/main/java/com/example/zhaogaofei/linearlayoutadapter/adapter)
