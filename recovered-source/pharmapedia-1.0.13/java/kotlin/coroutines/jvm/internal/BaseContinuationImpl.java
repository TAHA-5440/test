// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.coroutines.jvm.internal;
public abstract class BaseContinuationImpl implements ka.c, ma.b, java.io.Serializable {
    private final ka.c completion;

    public BaseContinuationImpl(ka.c p1)
    {
        this.completion = p1;
        return;
    }

    public ka.c create(Object p1, ka.c p2)
    {
        p2.getClass();
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public ka.c create(ka.c p2)
    {
        p2.getClass();
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public ma.b getCallerFrame()
    {
        int v0_0 = this.completion;
        if (!(v0_0 instanceof ma.b)) {
            return 0;
        } else {
            return ((ma.b) v0_0);
        }
    }

    public final ka.c getCompletion()
    {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement()
    {
        String v0_3 = ((ma.c) this.getClass().getAnnotation(ma.c));
        String v1_3 = 0;
        if ((v0_3 != null) && (v0_3.v() >= 1)) {
            int v2_0 = -1;
            try {
                boolean v4_4;
                boolean v4_2 = this.getClass().getDeclaredField("label");
                v4_2.setAccessible(1);
                boolean v4_3 = v4_2.get(this);
            } catch (Exception) {
                boolean v4_5 = -1;
                if (v4_5) {
                    v2_0 = v0_3.l()[v4_5];
                }
                String v3_3 = ma.d.b;
                boolean v4_7 = ma.d.a;
                if (v3_3 == null) {
                    try {
                        androidx.lifecycle.j v7_3 = new androidx.lifecycle.j(Class.getDeclaredMethod("getModule", 0), this.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", 0), this.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", 0), 21);
                        ma.d.b = v7_3;
                        v3_3 = v7_3;
                    } catch (Exception) {
                        ma.d.b = v4_7;
                        v3_3 = v4_7;
                    }
                }
                if (v3_3 != v4_7) {
                    boolean v4_9 = ((reflect.Method) v3_3.h);
                    if (v4_9) {
                        boolean v4_10 = v4_9.invoke(this.getClass(), 0);
                        if (v4_10) {
                            reflect.Method v5_9 = ((reflect.Method) v3_3.i);
                            if (v5_9 != null) {
                                boolean v4_11 = v5_9.invoke(v4_10, 0);
                                if (v4_11) {
                                    String v3_8;
                                    String v3_7 = ((reflect.Method) v3_3.j);
                                    if (v3_7 == null) {
                                        v3_8 = 0;
                                    } else {
                                        v3_8 = v3_7.invoke(v4_11, 0);
                                    }
                                    if ((v3_8 instanceof String)) {
                                        v1_3 = ((String) v3_8);
                                    }
                                }
                            }
                        }
                    }
                }
                String v1_1;
                if (v1_3 != null) {
                    String v3_10 = new StringBuilder();
                    v3_10.append(v1_3);
                    v3_10.append(47);
                    v3_10.append(v0_3.c());
                    v1_1 = v3_10.toString();
                } else {
                    v1_1 = v0_3.c();
                }
                return new StackTraceElement(v1_1, v0_3.m(), v0_3.f(), v2_0);
            }
            if (!(v4_3 instanceof Integer)) {
                v4_4 = 0;
            } else {
                v4_4 = ((Integer) v4_3);
            }
            boolean v4_6;
            if (!v4_4) {
                v4_6 = 0;
            } else {
                v4_6 = v4_4.intValue();
            }
            v4_5 = (v4_6 - 1);
        } else {
            return 0;
        }
    }

    public abstract Object invokeSuspend(Object p0);

    public void releaseIntercepted()
    {
        return;
    }

    public final void resumeWith(Object p4)
    {
        ka.c v0_0 = this;
        while(true) {
            ka.c v0_1 = ((kotlin.coroutines.jvm.internal.BaseContinuationImpl) v0_0);
            ka.c v1 = v0_1.completion;
            v1.getClass();
            p4 = v0_1.invokeSuspend(p4);
            if (p4 != kotlin.coroutines.intrinsics.CoroutineSingletons.g) {
                v0_1.releaseIntercepted();
                if (!(v1 instanceof kotlin.coroutines.jvm.internal.BaseContinuationImpl)) {
                    break;
                }
                v0_0 = v1;
            } else {
                return;
            }
        }
        v1.resumeWith(p4);
        return;
    }

    public String toString()
    {
        String v0_2 = new StringBuilder("Continuation at ");
        String v1_1 = this.getStackTraceElement();
        if (v1_1 == null) {
            v1_1 = this.getClass().getName();
        }
        v0_2.append(v1_1);
        return v0_2.toString();
    }
}
