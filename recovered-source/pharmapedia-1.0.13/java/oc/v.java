// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package oc;
public final class v extends oc.u {

    public static Long f0(java.nio.file.attribute.FileTime p4)
    {
        long v0_0 = e3.a.c(p4);
        int v4_1 = Long.valueOf(v0_0);
        if (v0_0 == 0) {
            return 0;
        } else {
            return v4_1;
        }
    }

    public final oc.n Z(oc.w p11)
    {
        p11.getClass();
        Long v1_0 = new String[0];
        java.nio.file.attribute.FileTime v11_11 = e3.a.j(p11.g.t(), v1_0);
        v11_11.getClass();
        Long v1_1 = 0;
        try {
            java.nio.file.attribute.FileTime v11_2;
            boolean v3_1 = new java.nio.file.LinkOption[1];
            v3_1[0] = java.nio.file.LinkOption.NOFOLLOW_LINKS;
            java.nio.file.attribute.BasicFileAttributes v0_0 = java.nio.file.Files.readAttributes(v11_11, java.nio.file.attribute.BasicFileAttributes, v3_1);
        } catch (java.nio.file.FileSystemException) {
            return 0;
        }
        if (!v0_0.isSymbolicLink()) {
            v11_2 = 0;
        } else {
            v11_2 = java.nio.file.Files.readSymbolicLink(v11_11);
        }
        int v5;
        boolean v3_2 = v0_0.isRegularFile();
        boolean v4_1 = v0_0.isDirectory();
        if (v11_2 == null) {
            v5 = 0;
        } else {
            v5 = ea.c.u(v11_2.toString());
        }
        int v7;
        Long v6_1 = Long.valueOf(v0_0.size());
        java.nio.file.attribute.FileTime v11_6 = v0_0.creationTime();
        if (v11_6 == null) {
            v7 = 0;
        } else {
            v7 = oc.v.f0(v11_6);
        }
        int v8;
        java.nio.file.attribute.FileTime v11_8 = v0_0.lastModifiedTime();
        if (v11_8 == null) {
            v8 = 0;
        } else {
            v8 = oc.v.f0(v11_8);
        }
        java.nio.file.attribute.FileTime v11_10 = v0_0.lastAccessTime();
        if (v11_10 != null) {
            v1_1 = oc.v.f0(v11_10);
        }
        return new oc.n(v3_2, v4_1, v5, v6_1, v7, v8, v1_1);
    }

    public final void h(oc.w p4, oc.w p5)
    {
        p4.getClass();
        p5.getClass();
        try {
            java.nio.file.CopyOption[] v1_3 = new String[0];
            String v4_6 = e3.a.j(p4.g.t(), v1_3);
            v4_6.getClass();
            java.nio.file.CopyOption[] v1_0 = new String[0];
            java.io.FileNotFoundException v5_3 = e3.a.j(p5.g.t(), v1_0);
            v5_3.getClass();
            java.nio.file.CopyOption[] v1_2 = new java.nio.file.CopyOption[2];
            v1_2[0] = java.nio.file.StandardCopyOption.ATOMIC_MOVE;
            v1_2[1] = java.nio.file.StandardCopyOption.REPLACE_EXISTING;
            java.nio.file.Files.move(v4_6, v5_3, v1_2);
            return;
        } catch (String v4_3) {
            throw new java.io.FileNotFoundException(v4_3.getMessage());
        } catch (UnsupportedOperationException) {
            oc.l.g("atomic move not supported");
            return;
        }
    }

    public final String toString()
    {
        return "NioSystemFileSystem";
    }
}
