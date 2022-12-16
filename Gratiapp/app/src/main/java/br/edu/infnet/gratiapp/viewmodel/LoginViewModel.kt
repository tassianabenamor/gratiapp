package br.edu.infnet.gratiapp.viewmodel

import androidx.lifecycle.ViewModel
import br.edu.infnet.gratiapp.models.UserInfo
import br.edu.infnet.gratiapp.repository.GratiappRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.firestore.DocumentReference

class LoginViewModel : ViewModel() {

    val TAG = "ViewModel"
    val repository = GratiappRepository.get()

    fun isLoggedIn(): Boolean {
        return repository.isLoggedIn()
    }

    fun login(
        email: String,
        password: String
    ): Task<AuthResult>{
        return GratiappRepository.auth.signInWithEmailAndPassword(email, password)

    }

    fun signOn(
        email: String,
        password: String
    ): Task<AuthResult>  {
        return repository.registerUserWithPassword(
            email,
            password
        )
    }

    fun registerUser(userInfo: UserInfo): Task<Void> {
        return repository.registerUser(userInfo)
    }
}