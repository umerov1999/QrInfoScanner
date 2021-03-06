package vn.vistark.qrinfoscanner.ui.material_batch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vn.vistark.qrinfoscanner.R
import vn.vistark.qrinfoscanner.core.entities.RawMaterialBatch
import vn.vistark.qrinfoscanner.core.entities.Shipment
import vn.vistark.qrinfoscanner.core.extensions.ViewExtension.Companion.clickAnimate
import vn.vistark.qrinfoscanner.core.interfaces.IClickable
import vn.vistark.qrinfoscanner.core.interfaces.IDeletable

class MaterialBatchAdapter(private val materialBatchs: ArrayList<RawMaterialBatch>) :
    RecyclerView.Adapter<MaterialBatchHolder>(), IClickable<RawMaterialBatch>,
    IDeletable<RawMaterialBatch> {

    override var onClick: ((RawMaterialBatch) -> Unit)? = null
    override var onDelete: ((RawMaterialBatch) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MaterialBatchHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_material_batch, parent, false)
        return MaterialBatchHolder(v)
    }

    override fun getItemCount(): Int {
        return materialBatchs.count()
    }

    override fun onBindViewHolder(holder: MaterialBatchHolder, position: Int) {
        val materialBatch = materialBatchs[position]
        holder.bind(materialBatch)

        holder.ilmIvDeleteIcon.clickAnimate {
            onDelete?.invoke(materialBatch)
        }
        holder.ilmLnRoot.clickAnimate {
            onClick?.invoke(materialBatch)
        }
    }

}