状态模式（State），当一个对象的内在状态改变时允许改变其行为，这个对象看起来
看起来相识改变了其类。

状态模式主要解决的是当控制一个对象状态转换的条件表达式过于复杂时的情况。把状态
的判断逻辑转移到表示不同状态的一系列类当中，可以把复杂的判断逻辑简化。当然，
如果这个状态判断很简单，那就没有必要用“状态模式”了。

状态模式的好处是将与特定状态相关的行为局部化，并且将不同状态的行为分割开来。
说白了，这样做的目的是为了消除庞大的条件分支语句。