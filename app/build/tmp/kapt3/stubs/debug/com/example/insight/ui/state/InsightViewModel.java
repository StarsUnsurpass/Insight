package com.example.insight.ui.state;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0010\u001a\u00020\u000bJ\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0012"}, d2 = {"Lcom/example/insight/ui/state/InsightViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/insight/ui/state/InsightUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "closeGraph", "", "onTextCaptured", "text", "", "reset", "showGraph", "startAnalysis", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class InsightViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.insight.ui.state.InsightUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.insight.ui.state.InsightUiState> uiState = null;
    
    @javax.inject.Inject()
    public InsightViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.insight.ui.state.InsightUiState> getUiState() {
        return null;
    }
    
    public final void onTextCaptured(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    private final void startAnalysis(java.lang.String text) {
    }
    
    public final void reset() {
    }
    
    public final void showGraph() {
    }
    
    public final void closeGraph() {
    }
}