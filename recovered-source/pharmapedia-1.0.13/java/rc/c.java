// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package rc;
public final class c extends w1.b {
    public final synthetic int d;

    public synthetic c(int p1)
    {
        this.d = p1;
        return;
    }

    public final boolean a(Object p2, Object p3)
    {
        switch (this.d) {
            case 0:
                return ((vet.pharmapedia.vetpharmapediapakistan.database.models.ContactsModel) p2).equals(((vet.pharmapedia.vetpharmapediapakistan.database.models.ContactsModel) p3));
            case 1:
                return ((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayDosageModel) p2).equals(((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayDosageModel) p3));
            case 2:
                return ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) p2).equals(((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) p3));
            case 3:
                return ((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsDetailModel) p2).equals(((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsDetailModel) p3));
            case 4:
                return ((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsModel) p2).equals(((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsModel) p3));
            case 5:
                return ((vet.pharmapedia.vetpharmapediapakistan.database.models.LanguagesModel) p2).equals(((vet.pharmapedia.vetpharmapediapakistan.database.models.LanguagesModel) p3));
            case 6:
                return ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesMainItemsModel) p2).equals(((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesMainItemsModel) p3));
            case 7:
                return ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) p2).equals(((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) p3));
            case 8:
                return ((vet.pharmapedia.vetpharmapediapakistan.database.models.SettingsModel) p2).equals(((vet.pharmapedia.vetpharmapediapakistan.database.models.SettingsModel) p3));
            default:
                return ((vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel) p3).equals(((vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel) p2));
        }
    }

    public final boolean b(Object p2, Object p3)
    {
        switch (this.d) {
            case 0:
                return kotlin.jvm.internal.f.a(((vet.pharmapedia.vetpharmapediapakistan.database.models.ContactsModel) p2).getName(), ((vet.pharmapedia.vetpharmapediapakistan.database.models.ContactsModel) p3).getName());
            case 1:
                return kotlin.jvm.internal.f.a(((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayDosageModel) p2).getAnimalName(), ((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayDosageModel) p3).getAnimalName());
            case 2:
                return kotlin.jvm.internal.f.a(((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) p2).getDocId(), ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) p3).getDocId());
            case 3:
                return kotlin.jvm.internal.f.a(((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsDetailModel) p2).getSaltName(), ((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsDetailModel) p3).getSaltName());
            case 4:
                return kotlin.jvm.internal.f.a(((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsModel) p2).getFormName(), ((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsModel) p3).getFormName());
            case 5:
                return kotlin.jvm.internal.f.a(((vet.pharmapedia.vetpharmapediapakistan.database.models.LanguagesModel) p2).getTranslationAbbr(), ((vet.pharmapedia.vetpharmapediapakistan.database.models.LanguagesModel) p3).getTranslationAbbr());
            case 6:
                return kotlin.jvm.internal.f.a(((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesMainItemsModel) p2).getItemName(), ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesMainItemsModel) p3).getItemName());
            case 7:
                return kotlin.jvm.internal.f.a(((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) p2).getDocId(), ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) p3).getDocId());
            case 8:
                return kotlin.jvm.internal.f.a(((vet.pharmapedia.vetpharmapediapakistan.database.models.SettingsModel) p2).getHeading(), ((vet.pharmapedia.vetpharmapediapakistan.database.models.SettingsModel) p3).getHeading());
            default:
                int v2_30;
                if (((vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel) p3).getSelectedTheme() != ((vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel) p2).getSelectedTheme()) {
                    v2_30 = 0;
                } else {
                    v2_30 = 1;
                }
                return v2_30;
        }
    }
}
