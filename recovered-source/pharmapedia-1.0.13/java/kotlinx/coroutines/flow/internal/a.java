// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.flow.internal;
public abstract class a implements kb.f {
    public final ka.g g;
    public final int h;
    public final kotlinx.coroutines.channels.BufferOverflow i;

    public a(ka.g p1, int p2, kotlinx.coroutines.channels.BufferOverflow p3)
    {
        this.g = p1;
        this.h = p2;
        this.i = p3;
        return;
    }

    public abstract Object a(ib.l p0, ka.c p1);

    public abstract kotlinx.coroutines.flow.internal.a b(ka.g p0, int p1, kotlinx.coroutines.channels.BufferOverflow p2);

    public Object collect(jb.c p3, ka.c p4)
    {
        ga.p v3_1 = gb.w.g(new kotlinx.coroutines.flow.internal.ChannelFlow$collect$2(p3, this, 0), p4);
        if (v3_1 != kotlin.coroutines.intrinsics.CoroutineSingletons.g) {
            return ga.p.a;
        } else {
            return v3_1;
        }
    }

    public final jb.b p(ka.g p5, int p6, kotlinx.coroutines.channels.BufferOverflow p7)
    {
        boolean v0_0 = this.g;
        kotlinx.coroutines.flow.internal.a v5_1 = p5.L(v0_0);
        kotlinx.coroutines.channels.BufferOverflow v2 = this.i;
        int v3 = this.h;
        if (p7 == kotlinx.coroutines.channels.BufferOverflow.g) {
            if (v3 != -3) {
                if (p6 != -3) {
                    if (v3 != -2) {
                        if (p6 != -2) {
                            p6 += v3;
                            if (p6 < 0) {
                                p6 = 2147483647;
                                p7 = v2;
                                if ((!kotlin.jvm.internal.f.a(v5_1, v0_0)) || ((p6 != v3) || (p7 != v2))) {
                                    return this.b(v5_1, p6, p7);
                                } else {
                                    return this;
                                }
                            }
                        }
                    }
                }
                p6 = v3;
            }
        }
    }

    public String toString()
    {
        String v0_1 = new java.util.ArrayList(4);
        int v2_2 = this.g;
        if (v2_2 != kotlin.coroutines.EmptyCoroutineContext.g) {
            int v1_17 = new StringBuilder("context=");
            v1_17.append(v2_2);
            v0_1.add(v1_17.toString());
        }
        int v2_0 = this.h;
        if (v2_0 != -3) {
            int v1_4 = new StringBuilder("capacity=");
            v1_4.append(v2_0);
            v0_1.add(v1_4.toString());
        }
        int v2_1 = this.i;
        if (v2_1 != kotlinx.coroutines.channels.BufferOverflow.g) {
            int v1_8 = new StringBuilder("onBufferOverflow=");
            v1_8.append(v2_1);
            v0_1.add(v1_8.toString());
        }
        StringBuilder v6_1 = new StringBuilder();
        v6_1.append(this.getClass().getSimpleName());
        v6_1.append(91);
        return r1.a.r(v6_1, ha.j.I(v0_1, ", ", 0, 0, 0, 62), 93);
    }
}
