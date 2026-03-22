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
import java.util.Arrays;
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
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(5) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `scan_record_table` (`id` TEXT NOT NULL, `originalImagePath` TEXT NOT NULL, `ocrText` TEXT NOT NULL, `llmAnalysisJson` TEXT NOT NULL, `coreKnowledgeId` TEXT NOT NULL, `studentId` TEXT NOT NULL, `isMastered` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `knowledge_nodes` (`nodeId` TEXT NOT NULL, `title` TEXT NOT NULL, `category` INTEGER NOT NULL, `importanceLevel` INTEGER NOT NULL, `canvasX` REAL NOT NULL, `canvasY` REAL NOT NULL, `description` TEXT NOT NULL, PRIMARY KEY(`nodeId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `knowledge_edges` (`edgeId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `sourceNodeId` TEXT NOT NULL, `targetNodeId` TEXT NOT NULL, `relationType` TEXT NOT NULL, FOREIGN KEY(`sourceNodeId`) REFERENCES `knowledge_nodes`(`nodeId`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`targetNodeId`) REFERENCES `knowledge_nodes`(`nodeId`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_knowledge_edges_sourceNodeId` ON `knowledge_edges` (`sourceNodeId`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_knowledge_edges_targetNodeId` ON `knowledge_edges` (`targetNodeId`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `knowledge_closure_table` (`ancestorId` TEXT NOT NULL, `descendantId` TEXT NOT NULL, `depth` INTEGER NOT NULL, PRIMARY KEY(`ancestorId`, `descendantId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `student_mastery` (`studentId` TEXT NOT NULL, `nodeId` TEXT NOT NULL, `masteryScore` REAL NOT NULL, `lastUpdateTime` INTEGER NOT NULL, PRIMARY KEY(`studentId`, `nodeId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `diagnostic_report_table` (`reportId` TEXT NOT NULL, `aiInsightText` TEXT NOT NULL, `radarVocabulary` REAL NOT NULL, `radarGrammar` REAL NOT NULL, `radarContext` REAL NOT NULL, `radarLogic` REAL NOT NULL, `radarCulture` REAL NOT NULL, `studentId` TEXT NOT NULL, `errorCauseJson` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`reportId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `student_table` (`studentId` TEXT NOT NULL, `name` TEXT NOT NULL, `gender` INTEGER NOT NULL, `age` INTEGER NOT NULL, `className` TEXT NOT NULL, `latestScore` REAL NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`studentId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `lesson_plan_table` (`planId` TEXT NOT NULL, `title` TEXT NOT NULL, `lessonType` TEXT NOT NULL, `keyPoints` TEXT NOT NULL, `difficulties` TEXT NOT NULL, `contentMarkdown` TEXT NOT NULL, `blocksJson` TEXT NOT NULL, `targetClassName` TEXT NOT NULL, `relatedKnowledgeNodeId` TEXT, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, PRIMARY KEY(`planId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `lesson_question_cross_ref` (`planId` TEXT NOT NULL, `questionId` TEXT NOT NULL, PRIMARY KEY(`planId`, `questionId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '26c23cf4dcd6a9399c65ee82cbb01181')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `scan_record_table`");
        db.execSQL("DROP TABLE IF EXISTS `knowledge_nodes`");
        db.execSQL("DROP TABLE IF EXISTS `knowledge_edges`");
        db.execSQL("DROP TABLE IF EXISTS `knowledge_closure_table`");
        db.execSQL("DROP TABLE IF EXISTS `student_mastery`");
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
        db.execSQL("PRAGMA foreign_keys = ON");
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
        final HashMap<String, TableInfo.Column> _columnsKnowledgeNodes = new HashMap<String, TableInfo.Column>(7);
        _columnsKnowledgeNodes.put("nodeId", new TableInfo.Column("nodeId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKnowledgeNodes.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKnowledgeNodes.put("category", new TableInfo.Column("category", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKnowledgeNodes.put("importanceLevel", new TableInfo.Column("importanceLevel", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKnowledgeNodes.put("canvasX", new TableInfo.Column("canvasX", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKnowledgeNodes.put("canvasY", new TableInfo.Column("canvasY", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKnowledgeNodes.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysKnowledgeNodes = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesKnowledgeNodes = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoKnowledgeNodes = new TableInfo("knowledge_nodes", _columnsKnowledgeNodes, _foreignKeysKnowledgeNodes, _indicesKnowledgeNodes);
        final TableInfo _existingKnowledgeNodes = TableInfo.read(db, "knowledge_nodes");
        if (!_infoKnowledgeNodes.equals(_existingKnowledgeNodes)) {
          return new RoomOpenHelper.ValidationResult(false, "knowledge_nodes(com.example.insight.data.local.entities.KnowledgeNodeEntity).\n"
                  + " Expected:\n" + _infoKnowledgeNodes + "\n"
                  + " Found:\n" + _existingKnowledgeNodes);
        }
        final HashMap<String, TableInfo.Column> _columnsKnowledgeEdges = new HashMap<String, TableInfo.Column>(4);
        _columnsKnowledgeEdges.put("edgeId", new TableInfo.Column("edgeId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKnowledgeEdges.put("sourceNodeId", new TableInfo.Column("sourceNodeId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKnowledgeEdges.put("targetNodeId", new TableInfo.Column("targetNodeId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKnowledgeEdges.put("relationType", new TableInfo.Column("relationType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysKnowledgeEdges = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysKnowledgeEdges.add(new TableInfo.ForeignKey("knowledge_nodes", "CASCADE", "NO ACTION", Arrays.asList("sourceNodeId"), Arrays.asList("nodeId")));
        _foreignKeysKnowledgeEdges.add(new TableInfo.ForeignKey("knowledge_nodes", "CASCADE", "NO ACTION", Arrays.asList("targetNodeId"), Arrays.asList("nodeId")));
        final HashSet<TableInfo.Index> _indicesKnowledgeEdges = new HashSet<TableInfo.Index>(2);
        _indicesKnowledgeEdges.add(new TableInfo.Index("index_knowledge_edges_sourceNodeId", false, Arrays.asList("sourceNodeId"), Arrays.asList("ASC")));
        _indicesKnowledgeEdges.add(new TableInfo.Index("index_knowledge_edges_targetNodeId", false, Arrays.asList("targetNodeId"), Arrays.asList("ASC")));
        final TableInfo _infoKnowledgeEdges = new TableInfo("knowledge_edges", _columnsKnowledgeEdges, _foreignKeysKnowledgeEdges, _indicesKnowledgeEdges);
        final TableInfo _existingKnowledgeEdges = TableInfo.read(db, "knowledge_edges");
        if (!_infoKnowledgeEdges.equals(_existingKnowledgeEdges)) {
          return new RoomOpenHelper.ValidationResult(false, "knowledge_edges(com.example.insight.data.local.entities.KnowledgeEdgeEntity).\n"
                  + " Expected:\n" + _infoKnowledgeEdges + "\n"
                  + " Found:\n" + _existingKnowledgeEdges);
        }
        final HashMap<String, TableInfo.Column> _columnsKnowledgeClosureTable = new HashMap<String, TableInfo.Column>(3);
        _columnsKnowledgeClosureTable.put("ancestorId", new TableInfo.Column("ancestorId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKnowledgeClosureTable.put("descendantId", new TableInfo.Column("descendantId", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsKnowledgeClosureTable.put("depth", new TableInfo.Column("depth", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysKnowledgeClosureTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesKnowledgeClosureTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoKnowledgeClosureTable = new TableInfo("knowledge_closure_table", _columnsKnowledgeClosureTable, _foreignKeysKnowledgeClosureTable, _indicesKnowledgeClosureTable);
        final TableInfo _existingKnowledgeClosureTable = TableInfo.read(db, "knowledge_closure_table");
        if (!_infoKnowledgeClosureTable.equals(_existingKnowledgeClosureTable)) {
          return new RoomOpenHelper.ValidationResult(false, "knowledge_closure_table(com.example.insight.data.local.entities.KnowledgeClosureEntity).\n"
                  + " Expected:\n" + _infoKnowledgeClosureTable + "\n"
                  + " Found:\n" + _existingKnowledgeClosureTable);
        }
        final HashMap<String, TableInfo.Column> _columnsStudentMastery = new HashMap<String, TableInfo.Column>(4);
        _columnsStudentMastery.put("studentId", new TableInfo.Column("studentId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudentMastery.put("nodeId", new TableInfo.Column("nodeId", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudentMastery.put("masteryScore", new TableInfo.Column("masteryScore", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudentMastery.put("lastUpdateTime", new TableInfo.Column("lastUpdateTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStudentMastery = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStudentMastery = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStudentMastery = new TableInfo("student_mastery", _columnsStudentMastery, _foreignKeysStudentMastery, _indicesStudentMastery);
        final TableInfo _existingStudentMastery = TableInfo.read(db, "student_mastery");
        if (!_infoStudentMastery.equals(_existingStudentMastery)) {
          return new RoomOpenHelper.ValidationResult(false, "student_mastery(com.example.insight.data.local.entities.StudentMasteryEntity).\n"
                  + " Expected:\n" + _infoStudentMastery + "\n"
                  + " Found:\n" + _existingStudentMastery);
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
    }, "26c23cf4dcd6a9399c65ee82cbb01181", "9b3233ca2712f9a041833f87065273cc");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "scan_record_table","knowledge_nodes","knowledge_edges","knowledge_closure_table","student_mastery","diagnostic_report_table","student_table","lesson_plan_table","lesson_question_cross_ref");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `scan_record_table`");
      _db.execSQL("DELETE FROM `knowledge_nodes`");
      _db.execSQL("DELETE FROM `knowledge_edges`");
      _db.execSQL("DELETE FROM `knowledge_closure_table`");
      _db.execSQL("DELETE FROM `student_mastery`");
      _db.execSQL("DELETE FROM `diagnostic_report_table`");
      _db.execSQL("DELETE FROM `student_table`");
      _db.execSQL("DELETE FROM `lesson_plan_table`");
      _db.execSQL("DELETE FROM `lesson_question_cross_ref`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
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
