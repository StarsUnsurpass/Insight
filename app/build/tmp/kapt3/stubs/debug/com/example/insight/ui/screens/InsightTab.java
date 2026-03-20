package com.example.insight.ui.screens;

import android.os.Build;
import android.widget.Toast;
import androidx.compose.animation.*;
import androidx.compose.animation.core.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material.icons.outlined.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import com.example.insight.ui.state.InsightViewModel;
import com.example.insight.ui.state.UserPreferences;
import com.example.insight.ui.state.UserRole;
import com.example.insight.graph.*;
import com.example.insight.ui.theme.*;
import com.example.insight.data.model.Courseware;
import com.example.insight.data.model.LessonPlanSample;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B/\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018\u00a8\u0006\u0019"}, d2 = {"Lcom/example/insight/ui/screens/InsightTab;", "", "title", "", "selectedIcon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "unselectedIcon", "index", "", "bias", "", "(Ljava/lang/String;ILjava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/ui/graphics/vector/ImageVector;IF)V", "getBias", "()F", "getIndex", "()I", "getSelectedIcon", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "getTitle", "()Ljava/lang/String;", "getUnselectedIcon", "Home", "Map", "Analysis", "Profile", "app_debug"})
public enum InsightTab {
    /*public static final*/ Home /* = new Home(null, null, null, 0, 0.0F) */,
    /*public static final*/ Map /* = new Map(null, null, null, 0, 0.0F) */,
    /*public static final*/ Analysis /* = new Analysis(null, null, null, 0, 0.0F) */,
    /*public static final*/ Profile /* = new Profile(null, null, null, 0, 0.0F) */;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.ui.graphics.vector.ImageVector selectedIcon = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.ui.graphics.vector.ImageVector unselectedIcon = null;
    private final int index = 0;
    private final float bias = 0.0F;
    
    InsightTab(java.lang.String title, androidx.compose.ui.graphics.vector.ImageVector selectedIcon, androidx.compose.ui.graphics.vector.ImageVector unselectedIcon, int index, float bias) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.ui.graphics.vector.ImageVector getSelectedIcon() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.ui.graphics.vector.ImageVector getUnselectedIcon() {
        return null;
    }
    
    public final int getIndex() {
        return 0;
    }
    
    public final float getBias() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.example.insight.ui.screens.InsightTab> getEntries() {
        return null;
    }
}