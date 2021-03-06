package com.openconference.sessiondetails

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates2.AbsListItemAdapterDelegate
import com.openconference.R
import com.openconference.sessiondetails.presentationmodel.SessionDetailItem
import com.openconference.sessiondetails.presentationmodel.SessionSeparatorItem

/**
 * Displays the description of a session
 *
 * @author Hannes Dorfmann
 */
open class DetailsSeparatorAdapterDelegate(protected val inflater: LayoutInflater) : AbsListItemAdapterDelegate<SessionSeparatorItem, SessionDetailItem, DetailsSeparatorAdapterDelegate.SeparatorViewHolder>() {


  override fun isForViewType(item: SessionDetailItem, items: MutableList<SessionDetailItem>?,
      position: Int): Boolean = item is SessionSeparatorItem

  override fun onCreateViewHolder(parent: ViewGroup): SeparatorViewHolder =
      SeparatorViewHolder(
          inflater.inflate(R.layout.item_session_details_separator, parent, false))

  override fun onBindViewHolder(item: SessionSeparatorItem, viewHolder: SeparatorViewHolder) {

  }

  class SeparatorViewHolder(v: View) : RecyclerView.ViewHolder(v)
}