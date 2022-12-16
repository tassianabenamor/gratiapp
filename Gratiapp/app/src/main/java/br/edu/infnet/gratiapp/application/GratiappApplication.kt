package br.edu.infnet.gratiapp.application

import android.app.Application
import br.edu.infnet.gratiapp.repository.GratiappRepository

class GratiappApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        GratiappRepository.initialize()
    }
}