package com.ba.optimizacionderutas

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.ba.optimizacionderutas.ui.theme.OptimizacionDeRutasTheme
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback,
    GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener {
    private lateinit var map: GoogleMap

    companion object {
        const val REQUEST_CODE_LOCATION = 0
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        createMarker()
        createPolyLine()
        map.setOnMyLocationButtonClickListener(this)
        map.setOnMyLocationClickListener(this)
        enableLocation()
    }

    private fun createPolyLine(){
        val polylineOptions = PolylineOptions()
            .add(LatLng(-11.859431,-77.081518))
            .add(LatLng(-11.859406,-77.083873))
            .add(LatLng(-11.857661,-77.082985))
            .add(LatLng(-11.855466,-77.085657))
            .add(LatLng(-11.854606,-77.084773))
            .add(LatLng(-11.850488,-77.081187))
            .add(LatLng(-11.84901 ,-77.090315))
            .add(LatLng(-11.843215,-77.088148))
            .add(LatLng(-11.842732,-77.086931))
            .add(LatLng(-11.839134,-77.085043))
            .add(LatLng(-11.835098,-77.084208))
            .add(LatLng(-11.833958,-77.090803))
            .add(LatLng(-11.829985,-77.091122))
            .add(LatLng(-11.827361,-77.093146))
            .add(LatLng(-11.919535,-77.089916))
            .add(LatLng(-11.919986,-77.088934))
            .add(LatLng(-11.919967,-77.088759))
            .add(LatLng(-11.916262,-77.082366))
            .add(LatLng(-11.913825,-77.086113))
            .add(LatLng(-11.912062,-77.086496))
            .add(LatLng(-11.908365,-77.083593))
            .add(LatLng(-11.908108,-77.083869))
            .add(LatLng(-11.874319,-77.089181))
            .add(LatLng(-11.886393,-77.075077))
            .add(LatLng(-11.882541,-77.07451 ))
            .add(LatLng(-11.882453,-77.074541))
            .add(LatLng(-11.87649 ,-77.069217))
            .add(LatLng(-11.872986,-77.069529))
            .add(LatLng(-11.870153,-77.070883))
            .add(LatLng(-11.873784,-77.074336))
            .add(LatLng(-11.875144,-77.074489))
            .add(LatLng(-11.869832,-77.077531))
            .add(LatLng(-11.869518,-77.079016))
            .add(LatLng(-11.870622,-77.080981))
            .add(LatLng(-11.867413,-77.080978))
            .add(LatLng(-11.868837,-77.076453))
            .add(LatLng(-11.868034,-77.074758))
            .add(LatLng(-11.868016,-77.074683))
            .add(LatLng(-11.865426,-77.07393 ))
            .add(LatLng(-11.864887,-77.074087))
            .add(LatLng(-11.864383,-77.074196))
            .add(LatLng(-11.864401,-77.074354))
            .add(LatLng(-11.863866,-77.078669))
            .add(LatLng(-11.860471,-77.079865))
            .add(LatLng(-11.862633,-77.080763))
            .add(LatLng(-11.864451,-77.086439))
            .add(LatLng(-11.866849,-77.088238))
            .add(LatLng(-11.862161,-77.090474))
            .add(LatLng(-11.860177,-77.093934))
            .add(LatLng(-11.861934,-77.094925))
            .add(LatLng(-11.860644,-77.104207))
            .add(LatLng(-11.850823,-77.105521))
            .add(LatLng(-11.846168,-77.106445))
            .add(LatLng(-11.84857 ,-77.110822))
            .add(LatLng(-11.849727,-77.115256))
            .add(LatLng(-11.84774 ,-77.116054))
            .add(LatLng(-11.838497,-77.112058))
            .add(LatLng(-11.833727,-77.113499))
            .add(LatLng(-11.833522,-77.113398))
            .add(LatLng(-11.833063,-77.113094))
            .add(LatLng(-11.832636,-77.112619))
            .add(LatLng(-11.831305,-77.111463))
            .add(LatLng(-11.829845,-77.111404))
            .add(LatLng(-11.829124,-77.110359))
            .add(LatLng(-11.829273,-77.113028))
            .add(LatLng(-11.831112,-77.113764))
            .add(LatLng(-11.829006,-77.114547))
            .add(LatLng(-11.829483,-77.118153))
            .add(LatLng(-11.825918,-77.116994))
            .add(LatLng(-11.821933,-77.1102  ))
            .add(LatLng(-11.820546,-77.109271))
            .add(LatLng(-11.820876,-77.108241))
            .add(LatLng(-11.829953,-77.105847))
            .add(LatLng(-11.832144,-77.108535))
            .add(LatLng(-11.835384,-77.109065))
            .add(LatLng(-11.835403,-77.109079))
            .add(LatLng(-11.836012,-77.109654))
            .add(LatLng(-11.843458,-77.101687))
            .add(LatLng(-11.843413,-77.101685))
            .add(LatLng(-11.842888,-77.101275))
            .add(LatLng(-11.842823,-77.101244))
            .add(LatLng(-11.842778,-77.101152))
            .add(LatLng(-11.844168,-77.09794 ))
            .add(LatLng(-11.84423 ,-77.097999))
            .add(LatLng(-11.847793,-77.096529))
            .add(LatLng(-11.856776,-77.099872))
            .add(LatLng(-11.858564,-77.100316))
            .add(LatLng(-11.858796,-77.100433))
            .add(LatLng(-11.859587,-77.09261 ))
            .add(LatLng(-11.853709,-77.08966 ))
            .add(LatLng(-11.853703,-77.089661))
            .add(LatLng(-11.851419,-77.092006))
            .add(LatLng(-11.850201,-77.093575))
            .add(LatLng(-11.840506,-77.094642))
            .add(LatLng(-11.829117,-77.101429))
            .add(LatLng(-11.829034,-77.101385))
            .add(LatLng(-11.827395,-77.100564))
            .add(LatLng(-11.818736,-77.09869 ))
            .add(LatLng(-11.817901,-77.098601))
            .add(LatLng(-11.81785 ,-77.098549))
            .add(LatLng(-11.81783 ,-77.098557))
            .add(LatLng(-11.815997,-77.099084))
            .add(LatLng(-11.816675,-77.094398))
            .add(LatLng(-11.917794,-77.095025))
            .add(LatLng(-11.921028,-77.095681))
            .add(LatLng(-11.923417,-77.089881))
            .add(LatLng(-11.927958,-77.087055))
            .add(LatLng(-11.931775,-77.089385))
            .add(LatLng(-11.931145,-77.09153 ))
            .add(LatLng(-11.929552,-77.09783 ))
            .add(LatLng(-11.929558,-77.097852))
            .add(LatLng(-11.937448,-77.097464))
            .add(LatLng(-11.936985,-77.093342))
            .add(LatLng(-11.936887,-77.093327))
            .add(LatLng(-11.938241,-77.08661 ))
            .add(LatLng(-11.935925,-77.083327))
            .add(LatLng(-11.935659,-77.083107))
            .add(LatLng(-11.932347,-77.086006))
            .add(LatLng(-11.929525,-77.07886 ))
            .add(LatLng(-11.928204,-77.080451))
            .add(LatLng(-11.925474,-77.081443))
            .add(LatLng(-11.924502,-77.086303))
            .add(LatLng(-11.92355 ,-77.085901))
            .add(LatLng(-11.920417,-77.084508))
            .add(LatLng(-11.922962,-77.080146))
            .add(LatLng(-11.925861,-77.079256))
            .add(LatLng(-11.923055,-77.078387))
            .add(LatLng(-11.917626,-77.073785))
            .add(LatLng(-11.916262,-77.076041))
            .add(LatLng(-11.91396 ,-77.074181))
            .add(LatLng(-11.913262,-77.073611))
            .add(LatLng(-11.912816,-77.07406 ))
            .add(LatLng(-11.908239,-77.072579))
            .add(LatLng(-11.9088  ,-77.071027))
            .add(LatLng(-11.90546 ,-77.070983))
            .add(LatLng(-11.905449,-77.070993))
            .add(LatLng(-11.901622,-77.072467))
            .add(LatLng(-11.901997,-77.070017))
            .add(LatLng(-11.895915,-77.067528))
            .add(LatLng(-11.89544 ,-77.068819))
            .add(LatLng(-11.89272 ,-77.067824))
            .add(LatLng(-11.890187,-77.068093))
            .add(LatLng(-11.890239,-77.068465))
            .add(LatLng(-11.890232,-77.068743))
            .add(LatLng(-11.890006,-77.06854 ))
            .add(LatLng(-11.886316,-77.068432))
            .add(LatLng(-11.880964,-77.068782))
            .add(LatLng(-11.880963,-77.068752))
            .add(LatLng(-11.877791,-77.064573))
            .add(LatLng(-11.877974,-77.061523))
            .add(LatLng(-11.878041,-77.06058 ))
            .add(LatLng(-11.873514,-77.05988 ))
            .add(LatLng(-11.869634,-77.059911))
            .add(LatLng(-11.865682,-77.053401))
            .add(LatLng(-11.850263,-77.058083))
            .add(LatLng(-11.852729,-77.05927 ))
            .add(LatLng(-11.855283,-77.065526))
            .add(LatLng(-11.856525,-77.065079))
            .add(LatLng(-11.856485,-77.067177))
            .add(LatLng(-11.853834,-77.067023))
            .add(LatLng(-11.849783,-77.072435))
            .add(LatLng(-11.822902,-77.059019))

            .color(ContextCompat.getColor(this,R.color.kotlin))

        val polyline = map.addPolyline(polylineOptions)
    }

    private fun createMarker() {
        val coordinates = LatLng(-11.865682,-77.053401)
        val marker = MarkerOptions().position(coordinates).title("Mi Casa")
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createFragment()
    }

    private fun createFragment() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun isLocationPermissionGranted() = ContextCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED

    private fun enableLocation() {
        if (!::map.isInitialized) return
        if (isLocationPermissionGranted()) {
            //Si
            map.isMyLocationEnabled = true
        } else {
            //No
            requestLocationPermission()
        }
    }

    private fun requestLocationPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        ) {
            Toast.makeText(this, "Ve a ajustes y acepta los permisos", Toast.LENGTH_SHORT).show()
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_CODE_LOCATION
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode){
            REQUEST_CODE_LOCATION -> if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                map.isMyLocationEnabled = true
            }else {
                Toast.makeText(this, "Para activar la localizacion ve a ajustes y acepta los permisos", Toast.LENGTH_SHORT).show()
            }
            else -> {}
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        if (!::map.isInitialized) return
        if(!isLocationPermissionGranted()){
            map.isMyLocationEnabled = false
            Toast.makeText(this, "Para activar la localizacion ve a ajustes y acepta los permisos", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onMyLocationButtonClick(): Boolean {
        Toast.makeText(this, "Boton Pulsado", Toast.LENGTH_SHORT).show()
        return false
    }

    override fun onMyLocationClick(p0: Location) {
        Toast.makeText(this, "Estas en ${p0.latitude}, ${p0.longitude}", Toast.LENGTH_SHORT).show()
    }
}