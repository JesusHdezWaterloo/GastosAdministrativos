package com.jhw.gestion.modules.gasto.ui.tipo_gasto;

import com.jhw.gestion.modules.gasto.core.domain.TipoGastoDomain;
import com.jhw.gestion.modules.gasto.ui.module.GastoModuleNavigator;
import com.jhw.gestion.modules.gasto.ui.module.GastoSwingModule;
import java.awt.event.ActionListener;
import com.jhw.swing.models.input.dialogs.DialogInputCBS;
import com.jhw.swing.models.input.icbs.InputComboBoxSelection;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class TipoGastoICBS extends InputComboBoxSelection<TipoGastoDomain> {

    public TipoGastoICBS() {
        super("Tipo de gasto");
        setIcon(GastoModuleNavigator.ICON_TIPO_GASTO);
    }

    @Override
    public void updateComboBox() throws Exception {
        setModel(GastoSwingModule.tipoGastoUC.findAll());
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
        new DialogInputCBS(this, TipoGastoInputView.from());
    }

}
