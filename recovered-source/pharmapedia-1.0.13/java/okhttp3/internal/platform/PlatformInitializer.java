// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package okhttp3.internal.platform;
public final class PlatformInitializer implements j2.b {

    public PlatformInitializer()
    {
        return;
    }

    public final Object create(android.content.Context p2)
    {
        int v0_1;
        p2.getClass();
        int v0_0 = ic.e.a;
        if (v0_0 == 0) {
            v0_1 = 0;
        } else {
            v0_1 = ((ic.d) v0_0);
        }
        if (v0_1 != 0) {
            v0_1.a(p2);
        }
        return ic.e.a;
    }

    public final java.util.List dependencies()
    {
        return kotlin.collections.EmptyList.g;
    }
}
