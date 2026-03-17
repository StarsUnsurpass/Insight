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
import com.example.insight.data.local.dao.LessonPlanDao;
import com.example.insight.data.local.dao.LessonPlanDao_Impl;
import com.example.insight.data.local.dao.ScanDao;
import com.example.insight.data.local.dao.ScanDao_Impl;
import com.example.insight.data.local.dao.StudentDao;
import com.example.insight.data.local.dao.StudentDao_Impl;
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

  private volatile StudentDao _studentDao;

  private volatile LessonPlanDao _lessonPlanDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(4) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `scan_record_table` (`id` TEXT NOT NULL, `originalImagePath` TEXT NOT NULL, `ocrText` TEXT NOT NULL, `llmAnalysisJson` TEXT NOT NULL, `coreKnowledgeId` TEXT NOT NULL, `studentId` TEXT NOT NULL, `isMastered` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `knowledge_node_table` (`nodeId` TEXT NOT NULL, `title` TEXT NOT NULL, `masteryLevel` REAL NOT NULL, `canvasX` REAL NOT NULL, `canvasY` REAL NOT NULL, PRIMARY KEY(`nodeId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `knowledge_edge_table` (`edgeId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `fromNodeId` TEXT NOT NULL, `toNodeId` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `diagnostic_report_table` (`reportId` TEXT NOT NULL, `aiInsightText` TEXT NOT NULL, `radarVocabulary` REAL NOT NULL, `radarGrammar` REAL NOT NULL, `radarContext` REAL NOT NULL, `radarLogic` REAL NOT NULL, `radarCulture` REAL NOT NULL, `studentId` TEXT NOT NULL, `errorCauseJson` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`reportId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `student_table` (`studentId` TEXT NOT NULL, `name` TEXT NOT NULL, `gender` INTEGER NOT NULL, `age` INTEGER NOT NULL, `className` TEXT NOT NULL, `latestScore` REAL NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`studentId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `lesson_plan_table` (`planId` TEXT NOT NULL, `title` TEXT NOT NULL, `lessonType` TEXT NOT NULL, `keyPoints` TEXT NOT NULL, `difficulties` TEXT NOT NULL, `contentMarkdown` TEXT NOT NULL, `blocksJson` TEXT NOT NULL, `targetClassName` TEXT NOT NULL, `relatedKnowledgeNodeId` TEXT, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, PRIMARY KEY(`planId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `lesson_question_cross_ref` (`planId` TEXT NOT NULL, `questionId` TEXT NOT NULL, PRIMARY KEY(`planId`, `questionId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '7968dc6ef4efce1c99b8e760820a024e')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `scan_record_table`");
        db.execSQL("DROP TABLE IF EXISTS `knowledge_node_table`");
        db.execSQL("DROP TABLE IF EXISTS `knowledge_edge_table`");
        db.execSQL("DROP TABLE IF EXISTS `diagnostic_report_table`");
        db.execSQL("DROP TABLE IF EXISTS `student_table`");
        db.execSQL("DROP TABLE IF EXISTS `lesson_plan_table`");
        db.execSQL("DROP TABLE IF EXISTS `lesson_question_cross_ref`");
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
        final HashMap<String, TableInfo.Column> _columnsScanRecordTable = new HashMap<String, TableInfo.Column>(8);
        _columnsScanRecordTable.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScanRecordTable.put("originalImagePath", new TableInfo.Column("originalImagePath", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScanRecordTable.put("ocrText", new TableInfo.Column("ocrText", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScanRecordTable.put("llmAnalysisJson", new TableInfo.Column("llmAnalysisJson", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScanRecordTable.put("coreKnowledgeId", new TableInfo.Column("coreKnowledgeId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScanRecordTable.put("studentId", new TableInfo.Column("studentId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
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
        final HashMap<String, TableInfo.Column> _columnsDiagnosticReportTable = new HashMap<String, TableInfo.Column>(10);
        _columnsDiagnosticReportTable.put("reportId", new TableInfo.Column("reportId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDiagnosticReportTable.put("aiInsightText", new TableInfo.Column("aiInsightText", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDiagnosticReportTable.put("radarVocabulary", new TableInfo.Column("radarVocabulary", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDiagnosticReportTable.put("radarGrammar", new TableInfo.Column("radarGrammar", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDiagnosticReportTable.put("radarContext", new TableInfo.Column("radarContext", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDiagnosticReportTable.put("radarLogic", new TableInfo.Column("radarLogic", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDiagnosticReportTable.put("radarCulture", new TableInfo.Column("radarCulture", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDiagnosticReportTable.put("studentId", new TableInfo.Column("studentId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
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
        final HashMap<String, TableInfo.Column> _columnsStudentTable = new HashMap<String, TableInfo.Column>(7);
        _columnsStudentTable.put("studentId", new TableInfo.Column("studentId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudentTable.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudentTable.put("gender", new TableInfo.Column("gender", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudentTable.put("age", new TableInfo.Column("age", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudentTable.put("className", new TableInfo.Column("className", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudentTable.put("latestScore", new TableInfo.Column("latestScore", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudentTable.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStudentTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStudentTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStudentTable = new TableInfo("student_table", _columnsStudentTable, _foreignKeysStudentTable, _indicesStudentTable);
        final TableInfo _existingStudentTable = TableInfo.read(db, "student_table");
        if (!_infoStudentTable.equals(_existingStudentTable)) {
          return new RoomOpenHelper.ValidationResult(false, "student_table(com.example.insight.data.local.entities.StudentEntity).\n"
                  + " Expected:\n" + _infoStudentTable + "\n"
                  + " Found:\n" + _existingStudentTable);
        }
        final HashMap<String, TableInfo.Column> _columnsLessonPlanTable = new HashMap<String, TableInfo.Column>(11);
        _columnsLessonPlanTable.put("planId", new TableInfo.Column("planId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLessonPlanTable.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLessonPlanTable.put("lessonType", new TableInfo.Column("lessonType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLessonPlanTable.put("keyPoints", new TableInfo.Column("keyPoints", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLessonPlanTable.put("difficulties", new TableInfo.Column("difficulties", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLessonPlanTable.put("contentMarkdown", new TableInfo.Column("contentMarkdown", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLessonPlanTable.put("blocksJson", new TableInfo.Column("blocksJson", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLessonPlanTable.put("targetClassName", new TableInfo.Column("targetClassName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLessonPlanTable.put("relatedKnowledgeNodeId", new TableInfo.Column("relatedKnowledgeNodeId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLessonPlanTable.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLessonPlanTable.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLessonPlanTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLessonPlanTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLessonPlanTable = new TableInfo("lesson_plan_table", _columnsLessonPlanTable, _foreignKeysLessonPlanTable, _indicesLessonPlanTable);
        final TableInfo _existingLessonPlanTable = TableInfo.read(db, "lesson_plan_table");
        if (!_infoLessonPlanTable.equals(_existingLessonPlanTable)) {
          return new RoomOpenHelper.ValidationResult(false, "lesson_plan_table(com.example.insight.data.local.entities.LessonPlanEntity).\n"
                  + " Expected:\n" + _infoLessonPlanTable + "\n"
                  + " Found:\n" + _existingLessonPlanTable);
        }
        final HashMap<String, TableInfo.Column> _columnsLessonQuestionCrossRef = new HashMap<String, TableInfo.Column>(2);
        _columnsLessonQuestionCrossRef.put("planId", new TableInfo.Column("planId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLessonQuestionCrossRef.put("questionId", new TableInfo.Column("questionId", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLessonQuestionCrossRef = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLessonQuestionCrossRef = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLessonQuestionCrossRef = new TableInfo("lesson_question_cross_ref", _columnsLessonQuestionCrossRef, _foreignKeysLessonQuestionCrossRef, _indicesLessonQuestionCrossRef);
        final TableInfo _existingLessonQuestionCrossRef = TableInfo.read(db, "lesson_question_cross_ref");
        if (!_infoLessonQuestionCrossRef.equals(_existingLessonQuestionCrossRef)) {
          return new RoomOpenHelper.ValidationResult(false, "lesson_question_cross_ref(com.example.insight.data.local.entities.LessonQuestionCrossRef).\n"
                  + " Expected:\n" + _infoLessonQuestionCrossRef + "\n"
                  + " Found:\n" + _existingLessonQuestionCrossRef);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "7968dc6ef4efce1c99b8e760820a024e", "2e137c9a5cf374abac62c7994b8d0de5");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "scan_record_table","knowledge_node_table","knowledge_edge_table","diagnostic_report_table","student_table","lesson_plan_table","lesson_question_cross_ref");
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
      _db.execSQL("DELETE FROM `student_table`");
      _db.execSQL("DELETE FROM `lesson_plan_table`");
      _db.execSQL("DELETE FROM `lesson_question_cross_ref`");
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
    _typeConvertersMap.put(StudentDao.class, StudentDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(LessonPlanDao.class, LessonPlanDao_Impl.getRequiredConverters());
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

  @Override
  public StudentDao studentDao() {
    if (_studentDao != null) {
      return _studentDao;
    } else {
      synchronized(this) {
        if(_studentDao == null) {
          _studentDao = new StudentDao_Impl(this);
        }
        return _studentDao;
      }
    }
  }

  @Override
  public LessonPlanDao lessonPlanDao() {
    if (_lessonPlanDao != null) {
      return _lessonPlanDao;
    } else {
      synchronized(this) {
        if(_lessonPlanDao == null) {
          _lessonPlanDao = new LessonPlanDao_Impl(this);
        }
        return _lessonPlanDao;
      }
    }
  }
}
