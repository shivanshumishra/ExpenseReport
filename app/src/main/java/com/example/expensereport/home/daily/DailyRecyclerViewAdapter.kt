package com.example.expensereport.home.daily

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.expensereport.R
import com.example.expensereport.db.model.Expense


class DailyRecyclerViewAdapter(private val expenseList: List<Expense>,val context: Context) : RecyclerView.Adapter<DailyRecyclerViewAdapter.DailyAdapterViewHolder>() {

    lateinit var hashMap: HashMap<String,Double>

    class DailyAdapterViewHolder(view: View) : ViewHolder(view){
        val tvDate:TextView = view.findViewById(R.id.tvDate)
        val tvCategory:TextView = view.findViewById(R.id.tvCategory)
        val tvAmount:TextView = view.findViewById(R.id.tvAmount)
        val dateTitle:TextView = view.findViewById(R.id.dateTitle)
        val dateTitleRow:LinearLayout = view.findViewById(R.id.dateTitleRow)
        val amountTotal:TextView = view.findViewById(R.id.amountTotal)
        val bottomLine: View = view.findViewById(R.id.bottomLine)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.daily_fragment_list_item,parent,false)
        hashMap = HashMap()
        expenseList.forEach {
            val amount = hashMap.getOrDefault(it.date,0.0)
            hashMap[it.date] = (amount + it.amount.toDouble())
        }
        return DailyAdapterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return expenseList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: DailyAdapterViewHolder, position: Int) {
        val rs = context.getString(R.string.Rs)
        holder.tvDate.text = expenseList[position].date
        holder.tvCategory.text = expenseList[position].category
        holder.tvAmount.text = rs + expenseList[position].amount
        val date = expenseList[position].date.split("-")[0]
        val totalAmount = hashMap.getOrDefault(expenseList[position].date,0)
        if(position == 0) {
            holder.dateTitle.text = date
            holder.amountTotal.text = "$rs $totalAmount"
        } else{
            if(expenseList[position - 1].date != expenseList[position].date){
                holder.bottomLine.visibility = View.VISIBLE
                holder.dateTitle.text = date
                holder.amountTotal.text = rs + totalAmount
                holder.dateTitle.visibility = View.VISIBLE
            } else {
                holder.bottomLine.visibility = View.GONE
                holder.dateTitleRow.visibility = View.GONE
            }
        }
    }
}