package com.openconference.model

import com.openconference.model.database.dao.SessionDao
import rx.Observable

/**
 * Responsible to load all sessions
 *
 * @author Hannes Dorfmann
 */
interface SessionsLoader {

  /**
   * Load all sessions
   */
  fun allSessions(): Observable<List<Session>>

  fun favoriteSessions(): Observable<List<Session>>

  fun getSession(id: String): Observable<Session>
}

/**
 * A [SessionsLoader] that uses the sessions from local database (synced with the backend)
 */
class LocalStorageSessionsLoader(private val scheduleDataAwareObservableFactory: ScheduleDataAwareObservableFactory, private val sessionDao: SessionDao) : SessionsLoader {

  override fun allSessions(): Observable<List<Session>> =
      scheduleDataAwareObservableFactory.create(sessionDao.getSessions())

  override fun favoriteSessions(): Observable<List<Session>> = scheduleDataAwareObservableFactory.create(
      sessionDao.getFavoriteSessions())

  override fun getSession(
      id: String): Observable<Session> = scheduleDataAwareObservableFactory.create(
      sessionDao.getById(id))
}