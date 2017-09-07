/*
package J_9_3_01;

import java.awt.*;
import java.beans.*;
import java.lang.reflect.*;

public class J_9_7_8
{
    //如果想在GUI的应用中生成的每一个AWT事件的记录，可以在发出事件的每一个组件中安装一个监听器。利用反射，可以很容易的自动完成这个工作
    private InvocationHandler handler;

    public J_9_7_8()
    {
        handler=new InvocationHandler()
        {
            public Object invoke(Object proxy,Method method,Object[] args)
            {
                System.out.println(method+":"+args[0]);
                return null;
            }
        };
    }


    /**
     * 为所有有监听器的事件暗转一个事件跟踪器
     */
/*
    public void add(Component c)
    {
        try
        {
            //得到所有可以监听的组件
            BeanInfo info=Introspector.getBeanInfo(c.getClass());

            EventSetDescriptor[] eventSets=info.getEventSetDescriptors();
            for(EventSetDescriptor eventSet:eventSets)
            {
                addListener(c,eventSet);
            }
        }
        catch(IntrospectionException e)
        {
        }

        if(c instanceof Container)
        {
            for(Component comp:((Container)c).getComponents())
            {
                add(comp);
            }
        }
    }

    public void addListener(Component c,EventSetDescriptor eventSet)
    {
        Object proxy=Proxy.newProxyInstance(null,new Class[]{eventSet.getListenerType()},handler);

        Method addListenerMethod=eventSet.getAddListenerMethod();
        try
        {
            addListenerMethod.invoke(c,proxy);
        }
        catch(ReflectiveOperationException e)
        {

        }

    }

}






/*

javax.swing
类 RepaintManager

java.lang.Object
  继承者 javax.swing.RepaintManager
public class RepaintManager


      extends
      Object

此类管理重绘请求，以最大限度地降低重绘次数。例如，通过将多个请求折叠到对组件树成员的单个重绘中。



currentManager

public static RepaintManager currentManager(Component c)
在给定 Component 的情况下，返回调用线程的 RepaintManager。
参数：
c - 在默认实现中未使用的 Component，但是重写版本可以使用它，以根据 Component 返回不同的 RepaintManager
返回：
RepaintManager 对象
currentManager

public static RepaintManager currentManager(JComponent c)
在给定 JComponent 的情况下，返回调用线程的 RepaintManager。
注：此方法用于与 Swing 库早期版本的向后二进制兼容性。它只返回 currentManager(Component) 返回的结果。

参数：
c - 未使用的 JComponent
返回：
RepaintManager 对象




getRootPane

public JRootPane getRootPane()
返回此组件的 JRootPane 祖先。
返回：
包含此组件的 JRootPane；如果未找到 JRootPane，则为 null



setDoubleBufferingEnabled

public void setDoubleBufferingEnabled(boolean aFlag)
在此 RepaintManager 中，启用或禁用双缓冲。小心：设置此属性的默认值可获得给定平台上的最佳绘制性能，不建议程序直接修改此属性。
参数：
aFlag - 如果激活双缓冲，则为 true



setDebugGraphicsOptions

public void setDebugGraphicsOptions(int debugOptions)
启用或禁用与组件或其某个子组件内执行的每个图形操作有关的诊断信息。
参数：
debugOptions - 确定组件应该如何显示信息；为下列选项之一：
DebugGraphics.LOG_OPTION - 打印文本消息。
DebugGraphics.FLASH_OPTION - 绘制的内容闪烁几次。
DebugGraphics.BUFFERED_OPTION - 创建一个 ExternalWindow，显示在 View 的脱屏缓冲区上执行的操作。
DebugGraphics.NONE_OPTION 禁用调试。
值 0 不会更改该调试选项。
当前值是 debugOptions 按位或运算的结果
getDebugGraphicsOptions

public int getDebugGraphicsOptions()
返回图形调试的状态。
返回：
0 标志或下列选项按位或运算的结果：
DebugGraphics.LOG_OPTION - 打印文本消息。
DebugGraphics.FLASH_OPTION - 绘制的内容闪烁几次。
DebugGraphics.BUFFERED_OPTION - 创建一个 ExternalWindow，显示在 View 的脱屏缓冲区上执行的操作。
DebugGraphics.NONE_OPTION 禁用调试。
值 0 不会更改该调试选项。



java.lang.reflect
接口 InvocationHandler

所有已知实现类：
CompositeDataInvocationHandler, EventHandler, MBeanServerInvocationHandler, RemoteObjectInvocationHandler
public interface InvocationHandler
InvocationHandler 是代理实例的调用处理程序 实现的接口。

每个代理实例都具有一个关联的调用处理程序。对代理实例调用方法时，将对方法调用进行编码并将其指派到它的调用处理程序的 invoke 方法。

invoke

Object invoke(Object proxy,
              Method method,
              Object[] args)
              throws Throwable
在代理实例上处理方法调用并返回结果。在与方法关联的代理实例上调用方法时，将在调用处理程序上调用此方法。
参数：
proxy - 在其上调用方法的代理实例
method - 对应于在代理实例上调用的接口方法的 Method 实例。 Method 对象的声明类将是在其中声明方法的接口，该接口可以是代理类赖以继承方法的代理接口的超接口。
args - 包含传入代理实例上方法调用的参数值的对象数组，如果接口方法不使用参数，则为 null。基本类型的参数被包装在适当基本包装器类（如 java.lang.Integer 或 java.lang.Boolean）的实例中。
返回：
从代理实例的方法调用返回的值。如果接口方法的声明返回类型是基本类型，则此方法返回的值一定是相应基本包装对象类的实例；否则，它一定是可分配到声明返回类型的类型。如果此方法返回的值为 null 并且接口方法的返回类型是基本类型，则代理实例上的方法调用将抛出 NullPointerException。否则，如果此方法返回的值与上述接口方法的声明返回类型不兼容，则代理实例上的方法调用将抛出 ClassCastException。


java.beans
接口 BeanInfo

所有已知子接口：
BeanContextServiceProviderBeanInfo
所有已知实现类：
SimpleBeanInfo
public interface BeanInfo
希望提供有关其 bean 的显式信息的 bean 实现者可以提供某个 BeanInfo 类，该类实现此 BeanInfo 接口并提供有关其 bean 的方法、属性、事件等显式信息。

bean 实现者不必提供一组完整的显式信息。可以挑选出希望提供的信息，其余部分将通过使用 bean 类方法的低级别反射和应用标准设计模式的自动分析来获得。

 BeanInfo[]	getAdditionalBeanInfo()
          此方法允许 BeanInfo 对象返回提供关于当前 bean 额外信息的 BeanInfo 对象组成的任意集合。
 BeanDescriptor	getBeanDescriptor()
          获得 beans BeanDescriptor。
 int	getDefaultEventIndex()
          bean 可能有一个“默认”事件，即使用 bean 时通常最有可能由用户使用的事件。
 int	getDefaultPropertyIndex()
          bean 可能有一个“默认”属性，即通常最有可能由自定义 bean 的用户一开始就选择更新的属性。
 EventSetDescriptor[]	getEventSetDescriptors()
          获得 beans EventSetDescriptor。
 Image	getIcon(int iconKind)
          此方法返回一个图像对象，可用该对象表示工具框、工具栏等中的 bean。
 MethodDescriptor[]	getMethodDescriptors()
          获得 beans MethodDescriptor。
 PropertyDescriptor[]	getPropertyDescriptors()
          获得 beans PropertyDescriptor。




getEventSetDescriptors

EventSetDescriptor[] getEventSetDescriptors()
获得 beans EventSetDescriptor。
返回：
描述由此 bean 激发事件种类的 EventSetDescriptor 数组。如果该信息应该通过自动分析获得，则可能返回 null。
 */
