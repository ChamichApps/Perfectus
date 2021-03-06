/*
 * Copyright (c) 2020 Chamich Apps. All rights reserved.
 */

package app.chamich.feature.authentication.extenstion

import androidx.databinding.ObservableField

/**
 * Returns string value if not null; otherwise empty string
 */
fun ObservableField<String>.value() = this.get() ?: ""
