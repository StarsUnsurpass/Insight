package com.example.insight.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.example.insight.data.local.dao.DiagnosticDao;
import com.example.insight.data.local.dao.DiagnosticDao_Impl;
import com.example.insight.data.local.dao.KnowledgeDao;
import com.example.insight.data.local.dao.KnowledgeDao_Impl;
import com.example.insight.data.local.dao.ScanDao;
import com.example.insight.data.local.dao.ScanDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile ScanDao _scanDao;

  private volatile KnowledgeDao _knowledgeDao;

  private volatile DiagnosticDao _diagnosticDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `scan_record_table` (`id` TEXT NOT NULL, `originalImagePath` TEXT NOT NULL, `ocrText` TEXT NOT NULL, `llmAnalysisJson` TEXT NOT NULL, `coreKnowledgeId` TEXT NOT NULL, `isMastered` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `knowledge_node_table` (`nodeId` TEXT NOT NULL, `title` TEXT NOT NULL, `masteryLevel` REAL NOT NULL, `canvasX` REAL NOT NULL, `canvasY` REAL NOT NULL, PRIMARY KEY(`nodeId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `knowledge_edge_table` (`edgeId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `fromNodeId` TEXT NOT NULL, `toNodeId` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `diagnostic_report_table` (`reportId` TEXT NOT NULL, `aiInsightText` TEXT NOT NULL, `radarVocabulary` REAL NOT NULL, `radarGrammar` REAL NOT NULL, `radarContext` REAL NOT NULL, `radarLogic` REAL NOT NULL, `radarCulture` REAL NOT NULL, `errorCauseJson` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`reportId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '96200e9a9e1966da858ce4998cfd5c04')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `scan_record_table`");
        db.execSQL("DROP TABLE IF EXISTS `knowledge_node_table`");
        db.execSQL("DROP TABLE IF EXISTS `knowledge_edge_table`");
        db.execSQL("DROP TABLE IF EXISTS `diagnostic_report_table`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsScanRecordTable = new HashMap<String, TableInfo.Column>(7);
        _columnsScanRecordTable.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScanRecordTable.put("originalImagePath", new TableInfo.Column("originalImagePath", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScanRecordTable.put("ocrText", new TableInfo.Column("ocrText", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScanRecordTable.put("llmAnalysisJson", new TableInfo.Column("llmAnalysisJson", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScanRecordTable.put("coreKnowledgeId", new TableInfo.Column("coreKnowledgeId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScanRecordTable.put("isMastered", new TableInfo.Column("isMastered", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScanRecordTable.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysScanRecordTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesScanRecordTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoScanRecordTable = new TableInfo("scan_record_table", _columnsScanRecordTable, _foreignKeysScanRecordTable, _indicesScanRecordTable);
        final TableInfo _existingScanRecordTable = TableInfo.read(db, "scan_record_table");
        if (!_infoScanRecordTable.equals(_existingScanRecordTable)) {
          return new RoomOpenHelper.ValidationResult(false, "scan_record_table(com.example.insight.data.local.entities.ScanRecordEntity).\n"
                  + " Expected:\n" + _infoScanRecordTable + "\n"
                  + " Found:\n" + _existingScanRecordTable);
        }
        final HashMap<String, TableInfo.Column> _columnsKnowledgeNodeTable = new HashMap<String, TableInfo.Column>(5);
        _columnsKnowledgeNodeTable.put("nodeId", new TableInfo.Column("nodeId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKnowledgeNodeTable.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKnowledgeNodeTable.put("masteryLevel", new TableInfo.Column("masteryLevel", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKnowledgeNodeTable.put("canvasX", new TableInfo.Column("canvasX", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKnowledgeNodeTable.put("canvasY", new TableInfo.Column("canvasY", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysKnowledgeNodeTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesKnowledgeNodeTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoKnowledgeNodeTable = new TableInfo("knowledge_node_table", _columnsKnowledgeNodeTable, _foreignKeysKnowledgeNodeTable, _indicesKnowledgeNodeTable);
        final TableInfo _existingKnowledgeNodeTable = TableInfo.read(db, "knowledge_node_table");
        if (!_infoKnowledgeNodeTable.equals(_existingKnowledgeNodeTable)) {
          return new RoomOpenHelper.ValidationResult(false, "knowledge_node_table(com.example.insight.data.local.entities.KnowledgeNodeEntity).\n"
                  + " Expected:\n" + _infoKnowledgeNodeTable + "\n"
                  + " Found:\n" + _existingKnowledgeNodeTable);
        }
        final HashMap<String, TableInfo.Column> _columnsKnowledgeEdgeTable = new HashMap<String, TableInfo.Column>(3);
        _columnsKnowledgeEdgeTable.put("edgeId", new TableInfo.Column("edgeId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKnowledgeEdgeTable.put("fromNodeId", new TableInfo.Column("fromNodeId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKnowledgeEdgeTable.put("toNodeId", new TableInfo.Column("toNodeId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysKnowledgeEdgeTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesKnowledgeEdgeTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoKnowledgeEdgeTable = new TableInfo("knowledge_edge_table", _columnsKnowledgeEdgeTable, _foreignKeysKnowledgeEdgeTable, _indicesKnowledgeEdgeTable);
        final TableInfo _existingKnowledgeEdgeTable = TableInfo.read(db, "knowledge_edge_table");
        if (!_infoKnowledgeEdgeTable.equals(_existingKnowledgeEdgeTable)) {
          return new RoomOpenHelper.ValidationResult(false, "knowledge_edge_table(com.example.insight.data.local.entities.KnowledgeEdgeEntity).\n"
                  + " Expected:\n" + _infoKnowledgeEdgeTable + "\n"
                  + " Found:\n" + _existingKnowledgeEdgeTable);
        }
        final HashMap<String, TableInfo.Column> _columnsDiagnosticReportTable = new HashMap<String, TableInfo.Column>(9);
        _columnsDiagnosticReportTable.put("reportId", new TableInfo.Column("reportId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDiagnosticReportTable.put("aiInsightText", new TableInfo.Column("aiInsightText", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDiagnosticReportTable.put("radarVocabulary", new TableInfo.Column("radarVocabulary", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDiagnosticReportTable.put("radarGrammar", new TableInfo.Column("radarGrammar", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDiagnosticReportTable.put("radarContext", new TableInfo.Column("radarContext", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDiagnosticReportTable.put("radarLogic", new TableInfo.Column("radarLogic", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDiagnosticReportTable.put("radarCulture", new TableInfo.Column("radarCulture", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDiagnosticReportTable.put("errorCauseJson", new TableInfo.Column("errorCauseJson", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDiagnosticReportTable.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDiagnosticReportTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDiagnosticReportTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDiagnosticReportTable = new TableInfo("diagnostic_report_table", _columnsDiagnosticReportTable, _foreignKeysDiagnosticReportTable, _indicesDiagnosticReportTable);
        final TableInfo _existingDiagnosticReportTable = TableInfo.read(db, "diagnostic_report_table");
        if (!_infoDiagnosticReportTable.equals(_existingDiagnosticReportTable)) {
          return new RoomOpenHelper.ValidationResult(false, "diagnostic_report_table(com.example.insight.data.local.entities.DiagnosticReportEntity).\n"
                  + " Expected:\n" + _infoDiagnosticReportTable + "\n"
                  + " Found:\n" + _existingDiagnosticReportTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "96200e9a9e1966da858ce4998cfd5c04", "051b55760beb93894ae4718bed385223");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "scan_record_table","knowledge_node_table","knowledge_edge_table","diagnostic_report_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `scan_record_table`");
      _db.execSQL("DELETE FROM `knowledge_node_table`");
      _db.execSQL("DELETE FROM `knowledge_edge_table`");
      _db.execSQL("DELETE FROM `diagnostic_report_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ScanDao.class, ScanDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(KnowledgeDao.class, KnowledgeDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(DiagnosticDao.class, DiagnosticDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public ScanDao scanDao() {
    if (_scanDao != null) {
      return _scanDao;
    } else {
      synchronized(this) {
        if(_scanDao == null) {
          _scanDao = new ScanDao_Impl(this);
        }
        return _scanDao;
      }
    }
  }

  @Override
  public KnowledgeDao knowledgeDao() {
    if (_knowledgeDao != null) {
      return _knowledgeDao;
    } else {
      synchronized(this) {
        if(_knowledgeDao == null) {
          _knowledgeDao = new KnowledgeDao_Impl(this);
        }
        return _knowledgeDao;
      }
    }
  }

  @Override
  public DiagnosticDao diagnosticDao() {
    if (_diagnosticDao != null) {
      return _diagnosticDao;
    } else {
      synchronized(this) {
        if(_diagnosticDao == null) {
          _diagnosticDao = new DiagnosticDao_Impl(this);
        }
        return _diagnosticDao;
      }
    }
  }
}
