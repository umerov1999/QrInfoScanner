package vn.vistark.qrinfoscanner.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.component_float_qr_scan_btn.*
import kotlinx.android.synthetic.main.home_menu_options.*
import kotlinx.android.synthetic.main.home_panel.*
import vn.vistark.qrinfoscanner.R
import vn.vistark.qrinfoscanner.core.constants.RuntimeStorage
import vn.vistark.qrinfoscanner.ui.account_info.AccountInfoActivity
import vn.vistark.qrinfoscanner.ui.qr_scan.QrScanActivity
import vn.vistark.qrinfoscanner.ui.shipment.ShipmentsActivity
import vn.vistark.qrinfoscanner.helpers.alert_helper.AlertHelper.Companion.showSelectStaticDataOptionAlert
import vn.vistark.qrinfoscanner.core.extensions.ViewExtension.Companion.clickAnimate
import vn.vistark.qrinfoscanner.helpers.FloatQuickScanButtonHelper

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        FloatQuickScanButtonHelper.initialize(asiIvQuickScanIcon, cfqsLnQuickScanBtn)
        loadImageGif()
        initEvents()

        loadUserInfo()
    }

    private fun loadUserInfo() {
        Glide.with(this)
            .load("")
            .placeholder(R.drawable.holder)
            .into(haIvUserProfileImage)

        haTvEnterpriseName.text =
            RuntimeStorage.CurrentEnterprise?.name ?: "Chúc bạn có một ngày tốt lành"

    }


    private fun initEvents() {
        hmoCvShipmentBtn.clickAnimate {
            val intent = Intent(this, ShipmentsActivity::class.java)
            startActivity(intent)
        }
        hmoCvStaticDataBtn.clickAnimate {
            this.showSelectStaticDataOptionAlert()
        }
        hmoCvGenerateQrBtn.clickAnimate {}
        hmoCvScanQRBtn.clickAnimate {
            val intent = Intent(this, QrScanActivity::class.java)
            intent.putExtra(QrScanActivity::class.java.simpleName, true)
            startActivity(intent)
        }
        ahcmpTvEditProfile.clickAnimate {
            val intent = Intent(this, AccountInfoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loadImageGif() {
        Glide.with(this).asGif().load(R.raw.qr_code_animation).into(ahcmpIvGenerateQR)
        Glide.with(this).asGif().load(R.raw.scan_qr_gif).into(ahcmpIvScanQR)
    }
}