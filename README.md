# LinearLayoutAdapter
适用于给LinearLayout进行增、删、改、查itemView的adapter

#### 适用场景：

少量的添加item View，同时不适合适用ListView的情况下

比如少量的item View外面嵌套有ScrollView，同时对item进行增、删、改、查操作

增：增加一条item，目前只支持在最下面添加

删：删除指定位置的任意一条item

改：更新数据，指定范围内的数据，从头开始更新数据，长度为0-所要更新数据的长度

查：获取LinearLayout添加的item View对应的数据信息
