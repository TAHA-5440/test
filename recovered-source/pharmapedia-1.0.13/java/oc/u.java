// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package oc;
public class u extends oc.o {

    public final void B(oc.w p3)
    {
        p3.getClass();
        if (Thread.interrupted()) {
            throw new java.io.InterruptedIOException("interrupted");
        } else {
            String v0_4 = p3.toFile();
            if ((!v0_4.delete()) && (v0_4.exists())) {
                oc.l.f(p3, "failed to delete ");
            }
            return;
        }
    }

    public final java.util.List M(oc.w p6)
    {
        String v0_0 = p6.toFile();
        String[] v1 = v0_0.list();
        if (v1 != null) {
            String v0_5 = new java.util.ArrayList();
            int v2 = v1.length;
            int v3 = 0;
            while (v3 < v2) {
                oc.w v4_0 = v1[v3];
                v4_0.getClass();
                v0_5.add(p6.d(v4_0));
                v3++;
            }
            ha.n.z(v0_5);
            return v0_5;
        } else {
            if (v0_0.exists()) {
                oc.l.f(p6, "failed to list ");
            } else {
                oc.l.l(p6, "no such file: ");
            }
            return 0;
        }
    }

    public oc.n Z(oc.w p10)
    {
        p10.getClass();
        int v10_2 = p10.toFile();
        boolean v1 = v10_2.isFile();
        boolean v2 = v10_2.isDirectory();
        int v3_1 = v10_2.lastModified();
        int v5_0 = v10_2.length();
        if ((v1) || ((v2) || ((v3_1 != 0) || ((v5_0 != 0) || (v10_2.exists()))))) {
            return new oc.n(v1, v2, 0, Long.valueOf(v5_0), 0, Long.valueOf(v3_1), 0);
        } else {
            return 0;
        }
    }

    public final oc.g c0(oc.w p4)
    {
        return new oc.g(new java.io.RandomAccessFile(p4.toFile(), "r"));
    }

    public final oc.b0 d(oc.w p3)
    {
        p3.getClass();
        return new oc.c(new java.io.FileOutputStream(p3.toFile(), 1), new oc.f0());
    }

    public final oc.b0 d0(oc.w p3)
    {
        p3.getClass();
        return new oc.c(new java.io.FileOutputStream(p3.toFile(), 0), new oc.f0());
    }

    public final oc.d0 e0(oc.w p3)
    {
        p3.getClass();
        return new oc.d(new java.io.FileInputStream(p3.toFile()), oc.f0.d);
    }

    public void h(oc.w p4, oc.w p5)
    {
        p4.getClass();
        p5.getClass();
        if (!p4.toFile().renameTo(p5.toFile())) {
            StringBuilder v1_1 = new StringBuilder("failed to move ");
            v1_1.append(p4);
            v1_1.append(" to ");
            v1_1.append(p5);
            throw new java.io.IOException(v1_1.toString());
        } else {
            return;
        }
    }

    public final void i(oc.w p3)
    {
        p3.getClass();
        if (!p3.toFile().mkdir()) {
            String v0_3 = this.Z(p3);
            if ((v0_3 == null) || (v0_3.c != 1)) {
                oc.l.f(p3, "failed to create directory: ");
            }
        }
        return;
    }

    public String toString()
    {
        return "JvmSystemFileSystem";
    }
}
