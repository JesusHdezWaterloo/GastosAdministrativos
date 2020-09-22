package com.jhw.gestion.modules.gasto.ui.tipo_gasto;

import com.jhw.gestion.modules.gasto.core.domain.TipoGastoDomain;
import com.jhw.gestion.modules.gasto.ui.module.GastoModuleNavigator;
import com.jhw.gestion.modules.gasto.ui.module.GastoSwingModule;
import com.jhw.swing.models.input.icbs.InputComboBoxSelection;
import com.jhw.swing.models.input.panels.ModelPanel;
import java.util.List;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class TipoGastoICBS extends InputComboBoxSelection<TipoGastoDomain> {

    public TipoGastoICBS() {
        setLabel("Tipo de gasto");
        setIcon(GastoModuleNavigator.ICON_TIPO_GASTO);
    }

    @Override
    public List<TipoGastoDomain> getList() throws Exception {
        return GastoSwingModule.tipoGastoUC.findAll();
    }

    @Override
    public ModelPanel<TipoGastoDomain> inputPanel() {
        return TipoGastoInputView.from();
    }

    @Override
    protected void addPropertyChange() {
        GastoSwingModule.tipoGastoUC.addPropertyChangeListener(this);
    }
}
