// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.coroutines;
public final class CombinedContext implements ka.g, java.io.Serializable {
    public final ka.g g;
    public final ka.e h;

    public CombinedContext(ka.e p1, ka.g p2)
    {
        p2.getClass();
        p1.getClass();
        this.g = p2;
        this.h = p1;
        return;
    }

    private final void readObject(java.io.ObjectInputStream p2)
    {
        throw new java.io.InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace()
    {
        int v0_0 = this.a();
        ka.g[] v1 = new ka.g[v0_0];
        int v2_1 = new kotlin.jvm.internal.Ref$IntRef();
        this.B(ga.p.a, new ka.b(v1, v2_1));
        if (v2_1.g != v0_0) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Check failed.");
            return 0;
        } else {
            return new kotlin.coroutines.CombinedContext$Serialized(v1);
        }
    }

    public final Object B(Object p2, ua.p p3)
    {
        return p3.invoke(this.g.B(p2, p3), this.h);
    }

    public final ka.g L(ka.g p3)
    {
        p3.getClass();
        if (p3 != kotlin.coroutines.EmptyCoroutineContext.g) {
            return ((ka.g) p3.B(this, new com.google.firebase.firestore.pipeline.evaluation.b(6)));
        } else {
            return this;
        }
    }

    public final ka.e Z(ka.f p3)
    {
        p3.getClass();
        kotlin.coroutines.CombinedContext v0_0 = this;
        while(true) {
            boolean v1_1 = v0_0.h.Z(p3);
            if (!v1_1) {
                kotlin.coroutines.CombinedContext v0_1 = v0_0.g;
                if (!(v0_1 instanceof kotlin.coroutines.CombinedContext)) {
                    break;
                }
                v0_0 = ((kotlin.coroutines.CombinedContext) v0_1);
            } else {
                return v1_1;
            }
        }
        return v0_1.Z(p3);
    }

    public final int a()
    {
        int v0 = 2;
        int v1_0 = this;
        while(true) {
            int v1_1 = v1_0.g;
            if (!(v1_1 instanceof kotlin.coroutines.CombinedContext)) {
                v1_0 = 0;
            } else {
                v1_0 = ((kotlin.coroutines.CombinedContext) v1_1);
            }
            if (v1_0 == 0) {
                break;
            }
            v0++;
        }
        return v0;
    }

    public final boolean equals(Object p5)
    {
        if (this != p5) {
            if (((p5 instanceof kotlin.coroutines.CombinedContext)) && (((kotlin.coroutines.CombinedContext) p5).a() == this.a())) {
                ka.e v0_1 = this;
                while(true) {
                    boolean v5_2;
                    ka.f v2_0 = v0_1.h;
                    if (kotlin.jvm.internal.f.a(((kotlin.coroutines.CombinedContext) p5).Z(v2_0.getKey()), v2_0)) {
                        ka.e v0_2 = v0_1.g;
                        if (!(v0_2 instanceof kotlin.coroutines.CombinedContext)) {
                            break;
                        }
                        v0_1 = ((kotlin.coroutines.CombinedContext) v0_2);
                    } else {
                        v5_2 = 0;
                    }
                    if (v5_2) {
                        return 1;
                    }
                }
                v0_2.getClass();
                ka.e v0_3 = ((ka.e) v0_2);
                v5_2 = kotlin.jvm.internal.f.a(((kotlin.coroutines.CombinedContext) p5).Z(v0_3.getKey()), v0_3);
            }
            return 0;
        }
        return 1;
    }

    public final int hashCode()
    {
        return (this.h.hashCode() + this.g.hashCode());
    }

    public final ka.g i(ka.f p4)
    {
        p4.getClass();
        ka.e v0 = this.h;
        ka.g v2 = this.g;
        if (v0.Z(p4) == null) {
            ka.g v4_1 = v2.i(p4);
            if (v4_1 != v2) {
                if (v4_1 != kotlin.coroutines.EmptyCoroutineContext.g) {
                    return new kotlin.coroutines.CombinedContext(v0, v4_1);
                } else {
                    return v0;
                }
            } else {
                return this;
            }
        } else {
            return v2;
        }
    }

    public final String toString()
    {
        return r1.a.r(new StringBuilder("["), ((String) this.B("", new com.google.firebase.firestore.pipeline.evaluation.b(5))), 93);
    }
}
