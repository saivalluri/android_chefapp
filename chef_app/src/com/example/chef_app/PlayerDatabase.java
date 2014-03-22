package com.example.chef_app;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

// The purpose of this class is to store information about the player's current progress
// to use as a way of generating the correct levels and also make level
// accomplishments available
public class PlayerDatabase {
	
	//Utility variables such as counters, etc.
	private static int levelcounter = 0;
	
	private static final String TAG = "playerdatabase";
	
	//Database information for reference
    public static final String DATABASE_NAME = "playerTable";
    public static final String DATABASE_TABLE = "PLAYERINFO";
    private static final int DATABASE_VERSION = 1;
    
    private Context ourContext;
	private DbHelper DBHelper;
	private static SQLiteDatabase db;

	
	
	//Columns in the database table
	public static final String COL_ID = "_id";
	public static final String LEVEL_ID = "LEVEL";
	
	//SQL string which defines the database table
	private static final String DATABASE_CREATE = 
     		"CREATE TABLE " + DATABASE_TABLE + " (" +
     		 COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
     		 LEVEL_ID + " INTEGER NOT NULL); ";
	
	
	/**
	 * @author Sai Valluri
	 * This is the nested DbHelper class which uses SQLite. As mentioned before, this class is responsible for the
	 * creation/upgrade and the transfer of data for the database.
	 */
	    public static class DbHelper extends SQLiteOpenHelper {
 
	        DbHelper(Context context) {
	            super(context, DATABASE_NAME, null, DATABASE_VERSION);
	        }
	        
	        public void onCreate(SQLiteDatabase db) {
	        	try {
	        		db.execSQL(DATABASE_CREATE);
	        	} catch (SQLException e) {
	        		e.printStackTrace();
	        	}
	        }
	        
	        @Override
	        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	        	Log.d("Database", "Updating player db ...");
	            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
	            onCreate(db);
	        }	
	    }
	    
	 // Constructor for the database
    	public PlayerDatabase(Context context) {
    		ourContext = context;
    	}
    	
    	/**
    	 * This method opens the database
    	 * @return
    	 * @throws SQLException
    	 */
		public PlayerDatabase open() throws SQLException {
        	DBHelper = new DbHelper(ourContext);
        	db = DBHelper.getWritableDatabase();
        	return this;
        }
		
        /**
         * This method closes the database
         */
        public void close() {
        	DBHelper.close();
        }
	    
	    
}
