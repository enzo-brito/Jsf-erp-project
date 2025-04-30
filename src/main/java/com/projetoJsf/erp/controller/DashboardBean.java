package com.projetoJsf.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

import com.projetoJsf.erp.model.TipoEmpresa;
import com.projetoJsf.erp.repository.Empresas;

@Named
@ViewScoped
public class DashboardBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private Empresas empresas;

    private PieChartModel empresasPorTipo;
    private BarChartModel empresasPorRamo;

    @PostConstruct
    public void init() {
        criarGraficoEmpresasPorTipo();
        criarGraficoEmpresasPorRamo();
    }

    private void criarGraficoEmpresasPorTipo() {
        empresasPorTipo = new PieChartModel();
        for (TipoEmpresa tipo : TipoEmpresa.values()) {
            long total = empresas.totalPorTipo(tipo);
            empresasPorTipo.set(tipo.name(), total);
        }
        empresasPorTipo.setTitle("Empresas por Tipo");
        empresasPorTipo.setLegendPosition("w");
    }

    private void criarGraficoEmpresasPorRamo() {
        empresasPorRamo = new BarChartModel();
        ChartSeries ramoSeries = new ChartSeries();
        ramoSeries.setLabel("Empresas");

        List<Object[]> dados = empresas.totalPorRamo(); 
        for (Object[] linha : dados) {
            ramoSeries.set(linha[0].toString(), (Long) linha[1]);
        }

        empresasPorRamo.addSeries(ramoSeries);
        empresasPorRamo.setTitle("Empresas por Ramo de Atividade");
        empresasPorRamo.setLegendPosition("ne");
        
        empresasPorRamo.getAxis(org.primefaces.model.chart.AxisType.X).setTickAngle(-45); 
        empresasPorRamo.getAxis(org.primefaces.model.chart.AxisType.X).setLabel("Ramos");
        empresasPorRamo.getAxis(org.primefaces.model.chart.AxisType.Y).setLabel("Quantidade");
    }

    public PieChartModel getEmpresasPorTipo() {
        return empresasPorTipo;
    }

    public BarChartModel getEmpresasPorRamo() {
        return empresasPorRamo;
    }
}
