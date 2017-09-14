# mockmvc


### mock stub 打桩

    List mock = mock( List.class );
    when( mock.get(0) ).thenReturn( 1 );
    assertEquals( "预期返回1", 1, mock.get( 0 ) );// mock.get(0) 返回 1

`迭代风格`

    // 第一种方式
    when(i.next()).thenReturn("Hello").thenReturn("World");
    // 第二种方式
    when(i.next()).thenReturn("Hello", "World");
    // 第三种方式，都是等价的
    when(i.next()).thenReturn("Hello");
    when(i.next()).thenReturn("World");

`无返回值`

    doNothing().when(obj).notify();
    // 或直接
    when(obj).notify();

`强制跑出异常`

    when(i.next()).thenThrow(new RuntimeException());
    doThrow(new RuntimeException()).when(i).remove(); // void 方法的
    // 迭代风格
    doNothing().doThrow(new RuntimeException()).when(i).remove();
    // 第一次调用 remove 方法什么都不做，第二次调用抛出 RuntimeException 异常。

`任意参数匹配`

    when(mockedList.get(anyInt())).thenReturn("element");
    System.out.println(mockedList.get(999));// 此时打印是 element

`verify验证`

    Map mock = Mockito.mock( Map.class );
    when( mock.get( "city" ) ).thenReturn( "广州" );
    // 关注参数有否传入
    verify(mock).get( Matchers.eq( "city" ) );
    // 关注调用的次数
    verify(mock, times( 2 ));

    Mockito 除了提供 times(N) 方法供我们调用外，还提供了很多可选的方法：

    never() 没有被调用，相当于 times(0)
    atLeast(N) 至少被调用 N 次
    atLeastOnce() 相当于 atLeast(1)
    atMost(N) 最多被调用 N 次

    verify 也可以像 when 那样使用模拟参数，若方法中的某一个参数使用了matcher，则所有的参数都必须使用 matcher。
    // correct
    verify(mock).someMethod(anyInt(), anyString(), eq("third argument"));
    // will throw exception
    verify(mock).someMethod(anyInt(), anyString(), "third argument");

### spy
> spy 的意思是你可以修改某个真实对象的某些方法的行为特征，而不改变他的基本行为特征，这种策略的使用跟 AOP 有点类似

    List list = new LinkedList();
    List spy = spy(list);

    //optionally, you can stub out some methods:
    when(spy.size()).thenReturn(100);

    //using the spy calls <b>real</b> methods
    spy.add("one");
    spy.add("two");

    //prints "one" - the first element of a list
    System.out.println(spy.get(0));

    //size() method was stubbed - 100 is printed
    System.out.println(spy.size());

    //optionally, you can verify
    verify(spy).add("one");
    verify(spy).add("two");


