package com.jhw.module.gestion.gastos.ui.tipo_gasto;

import com.jhw.module.gestion.contabilidad.ui.forma_pago.FormaPagoICBS;
import com.jhw.module.gestion.contabilidad.ui.tipo_operacion.TipoOperacionContableICBS;
import com.jhw.module.gestion.gastos.core.domain.TipoGastoDomain;
import com.jhw.module.gestion.gastos.ui.module.GastoSwingModule;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.material.components.textarea.MaterialTextArea;
import com.jhw.swing.prepared.textarea.MaterialPreparedTextAreaFactory;
import com.jhw.swing.material.components.textfield.MaterialTextFactory;
import com.jhw.swing.material.components.textfield.MaterialTextFieldIcon;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class TipoGastoInputView extends CleanCRUDInputView<TipoGastoDomain> {

    public static TipoGastoInputView from() {
        return new TipoGastoInputView(null);
    }

    public static TipoGastoInputView fromModel(TipoGastoDomain model) {
        return new TipoGastoInputView(model);
    }

    private TipoGastoInputView(TipoGastoDomain model) {
        super(model, GastoSwingModule.tipoGastoUC, TipoGastoDomain.class);
        initComponents();
        update();
    }

    private void initComponents() {
        setHeader("Crear Tipo de gasto", "Editar Tipo de gasto");

        textFieldNombre = MaterialTextFactory.buildIcon();
        textFieldNombre.setLabel("Nombre");
        textFieldNombre.setHint("Nombre del gasto");
        textFieldNombre.setIcon(MaterialIcons.PRIORITY_HIGH);

        monedaICBS = new com.jhw.module.gestion.contabilidad.ui.moneda.MonedaICBS();
        monedaICBS.setLabel("Moneda por defecto");
        monedaICBS.setIcon(MaterialIcons.ATTACH_MONEY);

        tipoOpICBS = new TipoOperacionContableICBS();
        tipoOpICBS.setLabel("Operación contable por defecto");

        formaPagoICBS = new FormaPagoICBS();

        textAreaDescripcion  = MaterialPreparedTextAreaFactory.buildDescripcion();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();
        vlc.add(textFieldNombre);
        vlc.add(monedaICBS);
        vlc.add(tipoOpICBS);
        vlc.add(formaPagoICBS);
        vlc.add(textAreaDescripcion, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private MaterialTextFieldIcon textFieldNombre;
    private com.jhw.module.gestion.contabilidad.ui.moneda.MonedaICBS monedaICBS;
    private TipoOperacionContableICBS tipoOpICBS;
    private FormaPagoICBS formaPagoICBS;
    private MaterialTextArea textAreaDescripcion;
    // End of variables declaration                   

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> map = super.bindFields();
        map.put("nombreGasto", textFieldNombre);
        map.put("monedaDefectoFk", monedaICBS);
        map.put("tipoOperacionContableDefectoFk", tipoOpICBS);
        map.put("formaPagoFk", formaPagoICBS);
        map.put("descripcion", textAreaDescripcion);
        return map;
    }

}
