// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.jvm.internal;
public abstract class CallableReference implements bb.b, java.io.Serializable {
    public static final Object NO_RECEIVER;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient bb.b reflected;
    private final String signature;

    static CallableReference()
    {
        kotlin.jvm.internal.CallableReference.NO_RECEIVER = kotlin.jvm.internal.CallableReference$NoReceiver.g;
        return;
    }

    public CallableReference(Object p1, Class p2, String p3, String p4, boolean p5)
    {
        this.receiver = p1;
        this.owner = p2;
        this.name = p3;
        this.signature = p4;
        this.isTopLevel = p5;
        return;
    }

    public varargs Object call(Object[] p2)
    {
        return this.getReflected().call(p2);
    }

    public Object callBy(java.util.Map p2)
    {
        return this.getReflected().callBy(p2);
    }

    public bb.b compute()
    {
        bb.b v0 = this.reflected;
        if (v0 == null) {
            v0 = this.computeReflected();
            this.reflected = v0;
        }
        return v0;
    }

    public abstract bb.b computeReflected();

    public reflect.GenericDeclaration findJavaDeclaration()
    {
        String v0_0 = this.getOwner();
        String v1 = this.getSignature();
        v1.getClass();
        if ((v0_0 instanceof kotlin.jvm.internal.a)) {
            UnsupportedOperationException v2_1;
            UnsupportedOperationException v2_0 = db.i.X(v1, 40, 0, 6);
            if (v2_0 != -1) {
                v2_1 = v1.substring(0, v2_0);
            } else {
                v2_1 = v1;
            }
            if (v2_1.equals("<init>")) {
                StringBuilder v3_4 = new StringBuilder("Generic Java constructors are not supported: ");
                v3_4.append(v0_0);
                v3_4.append(47);
                v3_4.append(v1);
                throw new UnsupportedOperationException(v3_4.toString());
            } else {
                String v0_5 = ((kotlin.jvm.internal.a) v0_0).a().getDeclaredMethods();
                v0_5.getClass();
                StringBuilder v3_5 = v0_5.length;
                int v5 = 0;
                while (v5 < v3_5) {
                    String v6 = v0_5[v5];
                    if (kotlin.jvm.internal.f.a(v6.getName(), v2_1)) {
                        boolean v7_3 = new StringBuilder();
                        v7_3.append(v6.getName());
                        v7_3.append("(");
                        Class v8_2 = v6.getParameterTypes();
                        v8_2.getClass();
                        int v9 = v8_2.length;
                        int v10 = 0;
                        while (v10 < v9) {
                            Class v11 = v8_2[v10];
                            v11.getClass();
                            kotlin.jvm.internal.j.a(v7_3, v11);
                            v10++;
                        }
                        v7_3.append(")");
                        Class v8_4 = v6.getReturnType();
                        v8_4.getClass();
                        kotlin.jvm.internal.j.a(v7_3, v8_4);
                        if (v7_3.toString().equals(v1)) {
                            return v6;
                        }
                    }
                    v5++;
                }
            }
        }
        return 0;
    }

    public java.util.List getAnnotations()
    {
        return this.getReflected().getAnnotations();
    }

    public Object getBoundReceiver()
    {
        return this.receiver;
    }

    public String getName()
    {
        return this.name;
    }

    public bb.d getOwner()
    {
        kotlin.jvm.internal.b v0_0 = this.owner;
        if (v0_0 != null) {
            if (!this.isTopLevel) {
                return kotlin.jvm.internal.h.a(v0_0);
            } else {
                kotlin.jvm.internal.h.a.getClass();
                return new kotlin.jvm.internal.g(v0_0);
            }
        } else {
            return 0;
        }
    }

    public java.util.List getParameters()
    {
        return this.getReflected().getParameters();
    }

    public abstract bb.b getReflected();

    public bb.l getReturnType()
    {
        this.getReflected().getReturnType();
        return 0;
    }

    public String getSignature()
    {
        return this.signature;
    }

    public java.util.List getTypeParameters()
    {
        return this.getReflected().getTypeParameters();
    }

    public kotlin.reflect.KVisibility getVisibility()
    {
        return this.getReflected().getVisibility();
    }

    public boolean isAbstract()
    {
        return this.getReflected().isAbstract();
    }

    public boolean isFinal()
    {
        return this.getReflected().isFinal();
    }

    public boolean isOpen()
    {
        return this.getReflected().isOpen();
    }

    public boolean isSuspend()
    {
        return this.getReflected().isSuspend();
    }
}
