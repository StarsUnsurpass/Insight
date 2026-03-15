package com.example.insight.data.local.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.insight.data.local.entities.DiagnosticReportEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DiagnosticDao_Impl implements DiagnosticDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<DiagnosticReportEntity> __insertionAdapterOfDiagnosticReportEntity;

  public DiagnosticDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDiagnosticReportEntity = new EntityInsertionAdapter<DiagnosticReportEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `diagnostic_report_table` (`reportId`,`aiInsightText`,`radarVocabulary`,`radarGrammar`,`radarContext`,`radarLogic`,`radarCulture`,`errorCauseJson`,`createdAt`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final DiagnosticReportEntity entity) {
        if (entity.getReportId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getReportId());
        }
        if (entity.getAiInsightText() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getAiInsightText());
        }
        statement.bindDouble(3, entity.getRadarVocabulary());
        statement.bindDouble(4, entity.getRadarGrammar());
        statement.bindDouble(5, entity.getRadarContext());
        statement.bindDouble(6, entity.getRadarLogic());
        statement.bindDouble(7, entity.getRadarCulture());
        if (entity.getErrorCauseJson() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getErrorCauseJson());
        }
        statement.bindLong(9, entity.getCreatedAt());
      }
    };
  }

  @Override
  public Object insertReport(final DiagnosticReportEntity report,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfDiagnosticReportEntity.insert(report);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<DiagnosticReportEntity> getLatestReportFlow() {
    final String _sql = "SELECT * FROM diagnostic_report_table ORDER BY createdAt DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"diagnostic_report_table"}, new Callable<DiagnosticReportEntity>() {
      @Override
      @Nullable
      public DiagnosticReportEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfReportId = CursorUtil.getColumnIndexOrThrow(_cursor, "reportId");
          final int _cursorIndexOfAiInsightText = CursorUtil.getColumnIndexOrThrow(_cursor, "aiInsightText");
          final int _cursorIndexOfRadarVocabulary = CursorUtil.getColumnIndexOrThrow(_cursor, "radarVocabulary");
          final int _cursorIndexOfRadarGrammar = CursorUtil.getColumnIndexOrThrow(_cursor, "radarGrammar");
          final int _cursorIndexOfRadarContext = CursorUtil.getColumnIndexOrThrow(_cursor, "radarContext");
          final int _cursorIndexOfRadarLogic = CursorUtil.getColumnIndexOrThrow(_cursor, "radarLogic");
          final int _cursorIndexOfRadarCulture = CursorUtil.getColumnIndexOrThrow(_cursor, "radarCulture");
          final int _cursorIndexOfErrorCauseJson = CursorUtil.getColumnIndexOrThrow(_cursor, "errorCauseJson");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final DiagnosticReportEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpReportId;
            if (_cursor.isNull(_cursorIndexOfReportId)) {
              _tmpReportId = null;
            } else {
              _tmpReportId = _cursor.getString(_cursorIndexOfReportId);
            }
            final String _tmpAiInsightText;
            if (_cursor.isNull(_cursorIndexOfAiInsightText)) {
              _tmpAiInsightText = null;
            } else {
              _tmpAiInsightText = _cursor.getString(_cursorIndexOfAiInsightText);
            }
            final float _tmpRadarVocabulary;
            _tmpRadarVocabulary = _cursor.getFloat(_cursorIndexOfRadarVocabulary);
            final float _tmpRadarGrammar;
            _tmpRadarGrammar = _cursor.getFloat(_cursorIndexOfRadarGrammar);
            final float _tmpRadarContext;
            _tmpRadarContext = _cursor.getFloat(_cursorIndexOfRadarContext);
            final float _tmpRadarLogic;
            _tmpRadarLogic = _cursor.getFloat(_cursorIndexOfRadarLogic);
            final float _tmpRadarCulture;
            _tmpRadarCulture = _cursor.getFloat(_cursorIndexOfRadarCulture);
            final String _tmpErrorCauseJson;
            if (_cursor.isNull(_cursorIndexOfErrorCauseJson)) {
              _tmpErrorCauseJson = null;
            } else {
              _tmpErrorCauseJson = _cursor.getString(_cursorIndexOfErrorCauseJson);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _result = new DiagnosticReportEntity(_tmpReportId,_tmpAiInsightText,_tmpRadarVocabulary,_tmpRadarGrammar,_tmpRadarContext,_tmpRadarLogic,_tmpRadarCulture,_tmpErrorCauseJson,_tmpCreatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
