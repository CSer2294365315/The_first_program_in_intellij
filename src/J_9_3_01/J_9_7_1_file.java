package J_9_3_01;

    import java.io.File;
    public class J_9_7_1_file {
        public static void main(String[] args) {
            File file=new File(".");
            System.out.println(file.exists());
            System.out.println(file.isDirectory());
            System.out.println(file.getAbsolutePath().toString());
        }
    }



/*

    setSelectedFile

public void setSelectedFile(File file)
设置选中的文件。如果该文件的父目录不是当前目录，则将当前目录更改为该文件的父目录。
参数：
file - 选中的文件


setMultiSelectionEnabled

public void setMultiSelectionEnabled(boolean b)
设置文件选择器，以允许选择多个文件。
参数：
b - 如果可以选择多个文件，则为 true



APPROVE_OPTION

public static final int APPROVE_OPTION
选择确认（yes、ok）后返回该值。
另请参见：
常量字段值
ERROR_OPTION

public static final int ERROR_OPTION
发生错误后返回该值。
另请参见：
常量字段值
FILES_ONLY

public static final int FILES_ONLY
指示仅显示文件。
另请参见：
常量字段值
DIRECTORIES_ONLY

public static final int DIRECTORIES_ONLY
指示仅显示目录。
另请参见：
常量字段值
FILES_AND_DIRECTORIES

public static final int FILES_AND_DIRECTORIES
指示显示文件和目录。

OPEN_DIALOG

public static final int OPEN_DIALOG
指示 JFileChooser 支持 "Open" 文件操作的类型值。
另请参见：
常量字段值
SAVE_DIALOG

public static final int SAVE_DIALOG
指示 JFileChooser 支持 "Save" 文件操作的类型值。
另请参见：
常量字段值
CUSTOM_DIALOG

public static final int CUSTOM_DIALOG
指示 JFileChooser 支持特定于开发人员文件操作的类型值。
另请参见：
常量字段值
CANCEL_OPTION

public static final int CANCEL_OPTION
选择 cancel 后的返回该值。



showSaveDialog

public int showSaveDialog(Component parent)
                   throws HeadlessException
弹出一个 "Save File" 文件选择器对话框。注意，approve 按钮上显示的文本由 L&F 决定。
参数：
parent - 该对话框的父组件，可以为 null；详情请参阅 showDialog
返回：
该文件选择器被弹下时的返回状态：
JFileChooser.CANCEL_OPTION
JFileChooser.APPROVE_OPTION
JFileChooser.ERROR_OPTION 如果发生错误或者该对话框已被解除
抛出：





*/