// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package cc;
public class z implements k3.a, r0.l {
    public final synthetic int g;
    public int h;
    public Object i;

    public z(int p1)
    {
        this.g = p1;
        switch (p1) {
            case 5:
                this.h = 1;
                this.i = java.util.Collections.singletonList(0);
                return;
            default:
                this.i = android.graphics.Bitmap$CompressFormat.JPEG;
                this.h = 100;
                return;
        }
    }

    public synthetic z(int p1, java.io.Serializable p2)
    {
        this.g = p1;
        this.h = 0;
        this.i = p2;
        return;
    }

    public synthetic z(int p1, boolean p2)
    {
        this.g = p1;
        return;
    }

    public z(android.content.Context p2)
    {
        this.g = 1;
        this(p2, i.g.e(p2, 0));
        return;
    }

    public z(android.content.Context p4, int p5)
    {
        this.g = 1;
        this.i = new i.c(new android.view.ContextThemeWrapper(p4, i.g.e(p4, p5)));
        this.h = p5;
        return;
    }

    public synthetic z(Object p1, int p2, int p3)
    {
        this.g = p3;
        this.i = p1;
        this.h = p2;
        return;
    }

    public z(java.util.ArrayList p2)
    {
        this.g = 0;
        this.i = p2;
        return;
    }

    public int a(int p5)
    {
        int v2_1;
        CharSequence v0_1 = ((CharSequence) this.i);
        int v1 = -1;
        if ((p5 <= 0) || (p5 > v0_1.length())) {
            v2_1 = -1;
        } else {
            v2_1 = Character.codePointBefore(v0_1, p5);
        }
        if (p5 < v0_1.length()) {
            v1 = Character.codePointAt(v0_1, p5);
        }
        return m6.k.a(v2_1, v1);
    }

    public i.g b()
    {
        l.n v1_1 = ((i.c) this.i);
        i.g v0_1 = new i.g(v1_1.a, this.h);
        boolean v2_8 = v1_1.e;
        i.f v3_1 = v0_1.l;
        if (!v2_8) {
            boolean v2_11 = v1_1.d;
            if (v2_11) {
                v3_1.d = v2_11;
                android.widget.ImageView v4_0 = v3_1.o;
                if (v4_0 != null) {
                    v4_0.setText(v2_11);
                }
                v3_1.c.setTitle(v2_11);
            }
            boolean v2_0 = v1_1.c;
            if (v2_0) {
                v3_1.m = v2_0;
                android.widget.ImageView v4_2 = v3_1.n;
                if (v4_2 != null) {
                    v4_2.setVisibility(0);
                    v3_1.n.setImageDrawable(v2_0);
                }
            }
        } else {
            v3_1.q = v2_8;
        }
        boolean v2_1 = v1_1.f;
        if (v2_1) {
            v3_1.e = v2_1;
            android.widget.ImageView v4_4 = v3_1.p;
            if (v4_4 != null) {
                v4_4.setText(v2_1);
            }
        }
        boolean v2_3 = v1_1.g;
        if (v2_3) {
            android.widget.ImageView v5_2;
            android.widget.ImageView v5_1 = v1_1.h;
            v3_1.getClass();
            if (v5_1 == null) {
                v5_2 = 0;
            } else {
                v5_2 = v3_1.y.obtainMessage(-1, v5_1);
            }
            v3_1.h = v2_3;
            v3_1.i = v5_2;
        }
        if (v1_1.k != null) {
            boolean v6_3;
            boolean v2_7 = ((androidx.appcompat.app.AlertController$RecycleListView) v1_1.b.inflate(v3_1.u, 0));
            if (!v1_1.m) {
                v6_3 = v3_1.w;
            } else {
                v6_3 = v3_1.v;
            }
            i.e v7_1 = v1_1.k;
            if (v7_1 == null) {
                v7_1 = new i.e(v1_1.a, v6_3, 16908308, 0);
            }
            v3_1.r = v7_1;
            v3_1.s = v1_1.n;
            if (v1_1.l != null) {
                v2_7.setOnItemClickListener(new i.b(v1_1, v3_1));
            }
            if (v1_1.m) {
                v2_7.setChoiceMode(1);
            }
            v3_1.f = v2_7;
        }
        v0_1.setCancelable(v1_1.i);
        if (v1_1.i) {
            v0_1.setCanceledOnTouchOutside(1);
        }
        v0_1.setOnCancelListener(0);
        v0_1.setOnDismissListener(0);
        l.n v1_2 = v1_1.j;
        if (v1_2 != null) {
            v0_1.setOnKeyListener(v1_2);
        }
        return v0_1;
    }

    public boolean c(android.view.View p2)
    {
        ((com.google.android.material.bottomsheet.BottomSheetBehavior) this.i).K(this.h);
        return 1;
    }

    public void d(int p3, int p4)
    {
        int v4_1 = (p4 + p3);
        char[] v0_1 = ((char[]) this.i);
        if (v0_1.length <= v4_1) {
            char[] v3_1 = (p3 * 2);
            if (v4_1 < v3_1) {
                v4_1 = v3_1;
            }
            this.i = java.util.Arrays.copyOf(v0_1, v4_1);
        }
        return;
    }

    public String e(int p3)
    {
        return ((String) this.i).substring(p3, this.h);
    }

    public void f(int p9, oc.e p10)
    {
        while(true) {
            oc.e[] v0_0 = (p9 >> 1);
            if (v0_0 == null) {
                break;
            }
            oc.e v1_2 = ((oc.e[]) this.i)[v0_0];
            v1_2.getClass();
            if (kotlin.jvm.internal.f.d(0, (p10.c - v1_2.c)) <= 0) {
                break;
            }
            v1_2.f = p9;
            ((oc.e[]) this.i)[p9] = v1_2;
            p9 = v0_0;
        }
        ((oc.e[]) this.i)[p9] = p10;
        p10.f = p9;
        return;
    }

    public y2.u g(y2.u p4, w2.g p5)
    {
        byte[] v5_1 = new java.io.ByteArrayOutputStream();
        ((android.graphics.Bitmap) p4.get()).compress(((android.graphics.Bitmap$CompressFormat) this.i), this.h, v5_1);
        p4.a();
        return new f3.z(v5_1.toByteArray());
    }

    public boolean h(char p3)
    {
        if (((String) this.i).charAt(this.h) != p3) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean i(String p2)
    {
        return this.o().startsWith(p2);
    }

    public boolean j()
    {
        if (this.h >= ((String) this.i).length()) {
            return 0;
        } else {
            return 1;
        }
    }

    public int k()
    {
        return ((String) this.i).codePointAt(this.h);
    }

    public int l()
    {
        int v0_2 = ((String) this.i).codePointAt(this.h);
        this.h = (Character.charCount(v0_2) + this.h);
        return v0_2;
    }

    public void m()
    {
        wb.b v0 = wb.b.c;
        Throwable v1_2 = ((char[]) this.i);
        v0.getClass();
        v1_2.getClass();
        try {
            ha.h v2_2 = v0.b;
        } catch (Throwable v1_1) {
            throw v1_1;
        }
        if ((v1_2.length + v2_2) < wb.a.a) {
            v0.b = (v2_2 + v1_2.length);
            v0.a.addLast(v1_2);
        }
        return;
    }

    public void n(oc.e p10)
    {
        int v0 = p10.f;
        if (v0 == -1) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("Failed requirement.");
            return;
        } else {
            int v2_1 = this.h;
            oc.e v3_2 = ((oc.e[]) this.i)[v2_1];
            v3_2.getClass();
            p10.f = -1;
            ((oc.e[]) this.i)[v2_1] = 0;
            this.h = (v2_1 - 1);
            if (p10 != v3_2) {
                oc.e[] v10_1 = kotlin.jvm.internal.f.d(0, (v3_2.c - p10.c));
                if (v10_1 != null) {
                    if (v10_1 >= null) {
                        this.f(v0, v3_2);
                        return;
                    }
                    while(true) {
                        oc.e[] v10_4;
                        oc.e[] v10_2 = (v0 << 1);
                        int v4_3 = (v10_2 + 1);
                        oc.e[] v5_0 = this.h;
                        if (v4_3 > v5_0) {
                            if (v10_2 > v5_0) {
                                break;
                            }
                            v10_4 = ((oc.e[]) this.i)[v10_2];
                            v10_4.getClass();
                            if (kotlin.jvm.internal.f.d(0, (v10_4.c - v3_2.c)) <= 0) {
                                break;
                            }
                            int v4_9 = v10_4.f;
                            v10_4.f = v0;
                            ((oc.e[]) this.i)[v0] = v10_4;
                            v0 = v4_9;
                        } else {
                            v10_4 = ((oc.e[]) this.i)[v10_2];
                            v10_4.getClass();
                            int v4_6 = ((oc.e[]) this.i)[v4_3];
                            v4_6.getClass();
                            if (kotlin.jvm.internal.f.d(0, (v4_6.c - v10_4.c)) >= 0) {
                                v10_4 = v4_6;
                            }
                        }
                    }
                    ((oc.e[]) this.i)[v0] = v3_2;
                    v3_2.f = v0;
                    return;
                } else {
                    ((oc.e[]) this.i)[v0] = v3_2;
                    v3_2.f = v0;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public String o()
    {
        return ((String) this.i).substring(this.h);
    }

    public void p(int p2)
    {
        this.h = (this.h + p2);
        return;
    }

    public int q(int p2)
    {
        if (p2 >= this.h) {
            return -8;
        } else {
            int v2_4 = Character.codePointAt(((CharSequence) this.i), p2);
            return (Character.charCount(v2_4) | (v2_4 << 3));
        }
    }

    public void r(String p6)
    {
        p6.getClass();
        int v0 = p6.length();
        if (v0 != 0) {
            this.d(this.h, v0);
            p6.getChars(0, p6.length(), ((char[]) this.i), this.h);
            this.h = (this.h + v0);
            return;
        } else {
            return;
        }
    }

    public String toString()
    {
        switch (this.g) {
            case 4:
                return this.o();
            case 8:
                return new String(((char[]) this.i), 0, this.h);
            default:
                return super.toString();
        }
    }
}
