package J_9_3_01;

public class J_9_8_1
{


}



/*
服务加载器

有时会开发采用插件体系结构的应用，JDK提供了一个加载插件的简单机制
通常，提供一个插件时，程序希望插件设计者能够有一些自由来确定如何实现插件的特性。另外，还可以有多个实现以供选择。例如有ServiceLoader类可以很容易的加载符合一个公共接口的插件。
定义一个接口，或者一个超类，其中包含服务的各个实例应当提供的方法。例如，你的服务要提供加密
package serviceLoader;

public interface Clipher
{
    byte[] encrypt(byte[] source,byte[] key);
    byte[] decrypt(byte[] source,byte[] key);
    int strength();
}

服务器提供者可以提供一个或者多个实现这个服务的类
package serviceLoader.imp;

public class CaesarCilher implements Clipher
{
    public byte[] encrypt(byte[] source,bytep[] key)
    {
        byte[] result=new byte[source.length];
        for(int i=0;i<source.length;i++)
            result[i]=(byte)(source[i]+key[0]);
        return result;
    }

    public byte[] decrypt(byte[] source,byte[] key)
    {
        return encrypt(source,new byte[]{(byte)-key[0]});
    }

    public int strength()
    {
        return 1;
    }
}

实现类也可以放在任意包中，而不一定式服务接口所在的包。每个实现类都必须有一个无参数的构造器。








 */
/*

java.util
类 ServiceLoader<S>

java.lang.Object
  继承者 java.util.ServiceLoader<S>
类型参数：
S - 要被此加载器加载的服务类型。


 Iterator<S>	iterator()
          以延迟方式加载此加载器服务的可用提供者。
static
<S> ServiceLoader<S>	load(Class<S> service)
          针对给定服务类型创建新的服务加载器，使用当前线程的上下文类加载器。
static
<S> ServiceLoader<S>	load(Class<S> service, ClassLoader loader)
          针对给定服务类型和类加载器创建新的服务加载器。
static
<S> ServiceLoader<S>	loadInstalled(Class<S> service)
          针对给定服务类型创建新的服务加载器，使用扩展类加载器。
 void	reload()
          清除此加载器的服务者缓存，以重载所有服务者。
 String	toString()
          返回一个描述此服务的字符串。


 */