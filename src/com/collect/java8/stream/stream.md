流式编程
    前言: 流是一系列与特定存储机制无关的元素
    声明书编程: 声明要做什么,而非怎么做
    外部迭代: ImperativeRandoms
    内部迭代:Randoms
    流是懒加载的 
1.流支持
    为了支持java已有的大量类库,为了保证平滑性。普通类中可以添加更多的方法,使用接口 添加Default方法
2.流创建
    1.随机数流
    2.int类型的范围 range()
    3.generate()      Stream.generate() 搭配 Supplier<T>
    4.iterate()
    5.流的建造者模式 FileToWordsBuilder
    6.Arrays    Arrays.Stream()
    7.正则表达式
3.中间操作
    1.跟踪和调试
        peek()
    2.流元素排序
        sorted()
    3.移除元素
        distinct()
        filter()
    4.应用函数到元素
        map(Function)
        mapToInt(ToIntFunction)
        mapToLong()
        mapToDouble
    5.在map中组合流
        flatMap() 将产生流的函数应用在每个元素上 然后将每个流都扁平化成元素,最终产生元素  
4.Optional类
        作为流元素的持有者, 即便元素不存在也不会发生异常
        findFirst()
        findAny()
        max()
        min()
        reduce()
        isPresent() 判断是否包含元素
        1.便利函数

        isPresent() 判断是否包含元素
        orElse(otherObject)：如果值存在则直接返回，否则生成 otherObject。
        orElseGet(Supplier)：如果值存在则直接返回，否则使用 Supplier 函数生成一个可替代对
        象。
        orElseThrow(Supplier)：如果值存在直接返回，否则使用 Supplier 函数生成一个异常。

2.创建Optional
        optional.empty()
        optional.of()
        optional.ofNull()
3.Optional对象操作
        filter
        map
        flatMap
4.Optional 流

5.终端操作
        1.数组
        2.循环

        parallel()：可实现多处理器并行操作

        forEach
        forEachOrdered(    
        3.集合
        4.组合

        