// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package oc;
public final synthetic class l implements t5.m {
    public final synthetic int g;

    public synthetic l(int p1)
    {
        this.g = p1;
        return;
    }

    public static synthetic void a()
    {
        throw new IllegalArgumentException();
    }

    public static synthetic void b(int p1, int p2, String p3)
    {
        StringBuilder v0_1 = new StringBuilder(p3);
        v0_1.append(p1);
        v0_1.append(p2);
        throw new IllegalArgumentException(v0_1.toString().toString());
    }

    public static synthetic void c(int p2, String p3)
    {
        StringBuilder v1_1 = new StringBuilder(p3);
        v1_1.append(p2);
        throw new IllegalArgumentException(v1_1.toString());
    }

    public static synthetic void d(Object p1)
    {
        throw new IllegalArgumentException(p1.toString());
    }

    public static synthetic void e(Object p1, Object p2, Object p3, Throwable p4)
    {
        StringBuilder v0_1 = new StringBuilder();
        v0_1.append(p1);
        v0_1.append(p2);
        v0_1.append(p3);
        throw new IllegalStateException(v0_1.toString(), p4);
    }

    public static synthetic void f(Object p2, String p3)
    {
        StringBuilder v1_1 = new StringBuilder(p3);
        v1_1.append(p2);
        throw new java.io.IOException(v1_1.toString());
    }

    public static synthetic void g(String p1)
    {
        throw new java.io.IOException(p1);
    }

    public static synthetic void h(String p1, Object p2, Object p3, Object p4, Object p5)
    {
        StringBuilder v0_1 = new StringBuilder(p1);
        v0_1.append(p2);
        v0_1.append(p3);
        v0_1.append(p4);
        v0_1.append(p5);
        throw new IllegalArgumentException(v0_1.toString());
    }

    public static synthetic void i(StringBuilder p0, Object p1)
    {
        p0.append(p1);
        throw new IllegalStateException(p0.toString());
    }

    public static synthetic void j(Throwable p1)
    {
        throw new RuntimeException(p1);
    }

    public static synthetic void k(int p1, String p2)
    {
        StringBuilder v0_1 = new StringBuilder(p2);
        v0_1.append(p1);
        throw new IllegalStateException(v0_1.toString().toString());
    }

    public static synthetic void l(Object p2, String p3)
    {
        StringBuilder v1_1 = new StringBuilder(p3);
        v1_1.append(p2);
        throw new java.io.FileNotFoundException(v1_1.toString());
    }

    public static synthetic void m(Object p2, String p3)
    {
        StringBuilder v1_1 = new StringBuilder(p3);
        v1_1.append(p2);
        throw new IllegalStateException(v1_1.toString());
    }

    public static synthetic void n(Object p1, String p2)
    {
        StringBuilder v0_1 = new StringBuilder(p2);
        v0_1.append(p1);
        v0_1.append(39);
        throw new IllegalArgumentException(v0_1.toString());
    }

    public static synthetic void o(Object p1, String p2)
    {
        StringBuilder v0_1 = new StringBuilder(p2);
        v0_1.append(p1);
        throw new IllegalStateException(v0_1.toString().toString());
    }

    public Object get()
    {
        throw new IllegalStateException();
    }
}
