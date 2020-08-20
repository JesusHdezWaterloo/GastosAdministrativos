package com.jhw.gestion.modules.gasto.ui.titular;

import java.awt.event.ActionListener;
import com.jhw.gestion.modules.gasto.ui.module.ContabilidadSwingModule;
import com.jhw.swing.models.input.dialogs.DialogInputCBS;
import com.jhw.swing.material.components.combobox.icbs.validated.ICBSNotEmptySeleccionable;
import com.jhw.gestion.modules.gasto.core.domain.TitularDomain;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class TitularICBS extends ICBSNotEmptySeleccionable<TitularDomain> {

    public TitularICBS() {
        super("Titular");
    }

    @Override
    public void updateComboBox() throws Exception {
        setModel(ContabilidadSwingModule.titularUC.findAll());
    }

    @Override
    public ActionListener buttonAddAction() {
        return new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onButtonAddActionPerformed();
            }
        };
    }

    private void onButtonAddActionPerformed() {
        new DialogInputCBS(this, new TitularInputView());
    }
}
