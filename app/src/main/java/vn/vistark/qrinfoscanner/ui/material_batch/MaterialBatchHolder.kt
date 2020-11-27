package vn.vistark.qrinfoscanner.ui.material_batch

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import vn.vistark.qrinfoscanner.R
import vn.vistark.qrinfoscanner.core.entities.RawMaterialBatch
import vn.vistark.qrinfoscanner.utils.AnimUtils.Companion.clickAnimate

class MaterialBatchHolder(v: View) : RecyclerView.ViewHolder(v) {
    private val ilmLnRoot: LinearLayout = v.findViewById(R.id.ilmLnRoot)
    private val ilmTvMaterialBatchId: TextView = v.findViewById(R.id.ilmTvMaterialBatchId)
    private val ilmTvMaterialBatchName: TextView = v.findViewById(R.id.ilmTvMaterialBatchName)
    private val ilmIvOptionsIcon: ImageView = v.findViewById(R.id.ilmIvOptionsIcon)
    private val ilmTvTotalWeightCount: TextView = v.findViewById(R.id.ilmTvTotalWeightCount)
    private val ilmTotalVesselCount: TextView = v.findViewById(R.id.ilmTotalVesselCount)
    private val ilmTvTotalSpiceCount: TextView = v.findViewById(R.id.ilmTvTotalSpiceCount)

    fun bind(materialBatch: RawMaterialBatch) {
        ilmIvOptionsIcon.clickAnimate { }
        ilmLnRoot.clickAnimate {

        }
        setMaterialBatchId(materialBatch.Id)
        setMaterialBatchName(materialBatch.Name)
        setTotalWeightCount(0F)
        setTotalVesselCount(0)
        setTotalSpiceCount(0)
    }

    private fun setMaterialBatchId(id: Int) {
        ilmTvMaterialBatchId.text = "#" + "$id".padStart(6, '0')
    }

    private fun setMaterialBatchName(name: String) {
        ilmTvMaterialBatchName.text = "Lô nguyên liệu ngày $name"
    }


    private fun setTotalWeightCount(float: Float) {
        ilmTvTotalWeightCount.text = "Kh.Lượng: $float (Tấn)"
    }

    private fun setTotalVesselCount(count: Int) {
        ilmTotalVesselCount.text = "Tàu liên kết: $count"
    }

    private fun setTotalSpiceCount(count: Int) {
        ilmTvTotalSpiceCount.text = "Tổng loài: $count"
    }
}