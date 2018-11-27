package com.shixing.githubapp

import com.shixing.common.Preference

object Settings {
    var email:String by Preference(AppContext, "email", "")
    var password:String by Preference(AppContext, "password", "")
}