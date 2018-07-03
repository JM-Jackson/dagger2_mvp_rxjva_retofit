package com.comagic.tabler.common.util;

/**
 * 日志工具，调式提供开关，并且输出可点击的追踪日志。
 *
 * @author
 */
public class LogUtil {
    public static boolean isDebug = true;

    private static String sApplicationTag = "LogUtil";// LOG默认TAG

    private static final String TAG_CONTENT_PRINT = "%s:%s.%s(%s:%d)";
    private static final String TAG_CONTENT_PRINT_SHORT = "(%s:%d)";
    private static final int MIN_STACK_OFFSET=3;    //最小的起始追踪偏移量

    public static void v(String tag, String msg) {
        if (isDebug)
            android.util.Log.v(tag, msg);
    }

    public static void v(String tag, String msg, Throwable t) {
        if (isDebug)
            android.util.Log.v(tag, msg, t);
    }

    public static void d(String tag, String msg) {
        if (isDebug) {
            try {
                android.util.Log.d(tag, msg);
            } catch (Exception e) {
                // nothing
            }
        }
    }

    public static void d(String tag, String msg, Throwable t) {
        if (isDebug)
            android.util.Log.d(tag, msg, t);
    }

    public static void i(String tag, String msg) {
        if (isDebug)
            android.util.Log.i(tag, msg);
    }

    public static void i(String tag, String msg, Throwable t) {
        if (isDebug)
            android.util.Log.i(tag, msg, t);
    }

    public static void w(String tag, String msg) {
        if (isDebug)
            android.util.Log.w(tag, msg);
    }

    public static void w(String tag, String msg, Throwable t) {
        if (isDebug)
            android.util.Log.w(tag, msg, t);
    }

    public static void e(String tag, String msg) {
        if (isDebug)
            android.util.Log.e(tag, msg);
    }

    public static void e(String tag, String msg, Throwable t) {
        if (isDebug)
            android.util.Log.e(tag, msg, t);
    }

    /**
     * 默认第6个调用栈
     */
    private static StackTraceElement getCurrentStackTraceElement() {
        return getCurrentStackTraceElement(5);
    }

    /**
     * 调用栈
     *
     * @param index 从0开始
     */
    private static StackTraceElement getCurrentStackTraceElement(int index) {
        return Thread.currentThread().getStackTrace()[index];
    }
    /**
     * 调用栈
     */
    private static StackTraceElement getCurrentStackTraceElementByClass() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int index=getStackOffset(stackTrace);
        return stackTrace[index];
    }

    /**
     * 获取完整LOG
     */
    private static String getContent(StackTraceElement trace) {
        return String.format(TAG_CONTENT_PRINT, sApplicationTag,
                getSimpleClassName(trace.getClassName()), trace.getMethodName(),
                trace.getFileName(), trace.getLineNumber());
    }

    /**
     * 获取简短LOG
     */
    private static String getContentShort(StackTraceElement trace) {
        if (trace==null)return "StackTraceElement trace 为null";
        return String.format(TAG_CONTENT_PRINT_SHORT, trace.getFileName(), trace.getLineNumber());
    }

    /**
     * 获取不可点击LOG
     */
    private static String getContentUnable(StackTraceElement trace) {
        return String.format(TAG_CONTENT_PRINT_SHORT, getSimpleClassName(trace.getClassName()),
                trace.getLineNumber());
    }

    /**
     * 打印Log当前调用栈信息
     *
     * @param mathod 调用Log的方法名
     */
    public static void trace(String mathod) {
        if (isDebug) {
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            System.out.println("call " + mathod + " method");
            System.out.println("stacktrace len:" + stacktrace.length);
            for (int i = 0; i < stacktrace.length; i++) {
                System.out.println("----  the " + i + " element  ----");
                System.out.println("toString: " + stacktrace[i].toString());
                System.out.println("ClassName: " + stacktrace[i].getClassName());
                System.out.println("FileName: " + stacktrace[i].getFileName());
                System.out.println("LineNumber: " + stacktrace[i].getLineNumber());
                System.out.println("MethodName: " + stacktrace[i].getMethodName());
            }
        }
    }

    /**
     * 打印日志追踪
     *
     * @param tag 标签
     * @param msg 信息
     */
    public static void dTrace(String tag, String msg) {
        if (isDebug) {
            d(tag, getContent(getCurrentStackTraceElement()) + ">" + msg);
        }
    }

    /**
     * 打印简洁日志追踪
     *
     * @param tag 标签
     * @param msg 信息
     */
    public static void dTraceShort(String tag, String msg) {
        if (isDebug) {
            d(tag, getContentShort(getCurrentStackTraceElement()) + " " + msg);
        }
    }

    /**
     * 打印简洁日志追踪,指定到第几个调用栈
     *
     * @param tag   标签
     * @param msg   信息
     * @param index 从0开始
     */
    public static void dTraceShortIndex(String tag, String msg, int index) {
        if (isDebug) {
            d(tag, getContentShort(getCurrentStackTraceElement(index)) + " " + msg);
        }
    }

    /**
     * 打印简洁日志追踪,指定到第几个调用栈
     *
     * @param tag   标签
     * @param msg   信息
     * @param index 从0开始
     */
    public static void iTraceShortIndex(String tag, String msg, int index) {
        if (isDebug) {
            i(tag, getContentShort(getCurrentStackTraceElement(index)) + " " + msg);
        }
    }
    /**
     * 打印简洁日志追踪,指定到clazz调用栈之后
     *
     * @param tag   标签
     * @param msg   信息
     */
    public static void iTraceShortIndexByClass(String tag, String msg) {
        if (isDebug) {
            i(tag, getContentShort(getCurrentStackTraceElementByClass()) + " " + msg);
        }
    }

    /**
     * 打印简洁日志追踪
     *
     * @param msg 信息
     */
    public static void dTraceShort(String msg) {
        dTraceShort(sApplicationTag, msg);
    }

    /**
     * 打印日志追踪,不可点击
     *
     * @param tag 标签
     * @param msg 信息
     */
    public static void dTraceUnable(String tag, String msg) {
        if (isDebug) {
            d(tag, getContentUnable(getCurrentStackTraceElement()) + " " + msg);
        }
    }

    /**
     * 打印日志追踪,不可点击
     *
     * @param tag 标签
     * @param msg 信息
     */
    public static void eTraceUnable(String tag, String msg) {
        if (isDebug) {
            e(tag, getContentUnable(getCurrentStackTraceElement()) + " " + msg);
        }
    }

    /**
     * 打印简洁日志追踪,不可点击
     *
     * @param msg 信息
     */
    public static void dTraceUnable(String msg) {
        dTraceUnable(sApplicationTag, msg);
    }

    /**
     * 打印日志追踪,默认Tag
     *
     * @param msg 信息
     */
    public static void dTrace(String msg) {
        if (isDebug) {
            d(sApplicationTag, getContent(getCurrentStackTraceElement()) + ">" + msg);
        }
    }

    private static String getSimpleClassName(String name) {
        int lastIndex = name.lastIndexOf(".");
        return name.substring(lastIndex + 1);
    }
    /**
     * 获得指定RequstClient,LogUtil之后的追踪偏移量
     *
     * @param trace the stack trace
     * @return the stack offset
     */
    private static int getStackOffset(StackTraceElement[] trace) {
        for (int i = MIN_STACK_OFFSET; i < trace.length; i++) {
            StackTraceElement e = trace[i];
            String name = e.getClassName();
            if (!name.equals(LogUtil.class.getName())) {
                return i;
            }
        }
        return -1;
    }
}