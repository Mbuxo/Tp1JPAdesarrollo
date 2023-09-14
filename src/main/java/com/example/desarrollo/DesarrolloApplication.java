package com.example.desarrollo;

import com.example.desarrollo.Enumeraciones.EstadoPedido;
import com.example.desarrollo.Enumeraciones.FormadePago;
import com.example.desarrollo.Enumeraciones.Tipo;
import com.example.desarrollo.Enumeraciones.TipoEnvio;
import com.example.desarrollo.entidades.*;
import com.example.desarrollo.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;
import java.util.Date;

//import static com.example.desarrollo.entidades.TipoEnvio.DELIVERY;
//import static com.example.desarrollo.entidades.TipoEnvio.estado.INICIADO;

@SpringBootApplication
public class DesarrolloApplication {

	@Autowired
	ClienteRepositorio clienteRepositorio;
	@Autowired
	RubroRepositorio rubroRepositorio;
	@Autowired
	FacturaRepositorio facturaRepositorio;
	@Autowired
	PedidoRepositorio pedidoRepositorio;




	public static void main(String[] args) {

		SpringApplication.run(DesarrolloApplication.class, args);
		System.out.println("Probando One to many");

	}

	@Bean
	CommandLineRunner init (ClienteRepositorio clienteRepositorio, RubroRepositorio rubroRepositorio, FacturaRepositorio facturaRepositorio,PedidoRepositorio pedidoRepositorio) {
		return args -> {
			System.out.println("FUNCIONANDO");
			Domicilio domicilio1 = Domicilio.builder()
					.calle("Calle 1")
					.numero("556")
					.localidad("Capital")
					.build();

			Domicilio domicilio2 = Domicilio.builder()
					.calle("Calle 2")
					.numero("471")
					.localidad("Godoy Cruz")
					.build();


			Cliente cliente = Cliente.builder()
					.nombre("Ezequiel")
					.apellido("Buxo")
					.telefono("1564")
					.email("ezequielbuxo@....")
					.build();
			Domicilio domicilio3 = Domicilio.builder()
					.calle("Calle 3")
					.numero("556")
					.localidad("Capital")
					.build();

			Domicilio domicilio4 = Domicilio.builder()
					.calle("Calle 4")
					.numero("471")
					.localidad("Godoy Cruz")
					.build();


			Cliente cliente1 = Cliente.builder()
					.nombre("Manuel")
					.apellido("Rey")
					.telefono("5627")
					.email("manuelrey@")
					.build();
			cliente1.agregarDomicilio(domicilio3);
			cliente1.agregarDomicilio(domicilio4);
			clienteRepositorio.save(cliente1);


			cliente.agregarDomicilio(domicilio1);
			cliente.agregarDomicilio(domicilio2);

			Factura factura1=Factura.builder()
					.numero(23)
					.fecha(new Date())
					.descuento(10.00)
					.formapago(FormadePago.EFECTIVO)
					.total(10000.00)
					.build();

			factura1.calcularTotalConDescuento();
			facturaRepositorio.save(factura1);

			Factura factura2=Factura.builder()
					.numero(24)
					.fecha(new Date())
					.descuento(20.00)
					.formapago(FormadePago.EFECTIVO)
					.total(9500.00)
					.build();
			factura2.calcularTotalConDescuento();
			facturaRepositorio.save(factura2);

			Pedido pedido1 = Pedido.builder()
					.estado(EstadoPedido.INICIADO)
					.fecha(new Date())
					.tipoenvio(TipoEnvio.RETIRA)
					.total(10000.00)
					.build();

			Pedido pedido2 = Pedido.builder()
					.estado(EstadoPedido.FINALIZADO)
					.fecha(new Date())
					.tipoenvio(TipoEnvio.DELIVERY)
					.total(9500.00)
					.build();

			cliente.nuevoPedido(pedido1);
			cliente.nuevoPedido(pedido2);





			clienteRepositorio.save(cliente);
			Rubro rubro = Rubro.builder()
					.denominacion("Local")
					.build();
			Producto producto1= Producto.builder()
					.tipo(Tipo.INSUMO)
					.tiempoEstimadoCocina(21)
					.denominacion("Local")
					.precioVenta(2000.00)
					.precioCompra(1000.00)
					.stockActual(5)
					.stockMinimo(2)
					.unidadMedida("kilos")
					.receta("....")
					.build();

			Producto producto2= Producto.builder()
					.tipo(Tipo.INSUMO)
					.tiempoEstimadoCocina(21)
					.denominacion("Local")
					.precioVenta(2000.00)
					.precioCompra(1000.00)
					.stockActual(5)
					.stockMinimo(2)
					.unidadMedida("unidad")
					.receta("....")
					.build();

			rubro.agregarProducto(producto1);
			rubro.agregarProducto(producto2);
			rubroRepositorio.save(rubro);




			DetallePedido detalle1Pedido1 = DetallePedido.builder()
					.cantidad(1)
					.subtotal(3000.00)
					.build();
			pedido1.agregarDetallepedido(detalle1Pedido1);

			DetallePedido detalle2Pedido1 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(7000.00)
					.build();

			pedido1.agregarDetallepedido(detalle2Pedido1);
			pedidoRepositorio.save(pedido1);

			DetallePedido detalle1Pedido2 = DetallePedido.builder()
					.cantidad(1)
					.subtotal(3500.00)
					.build();
			pedido2.agregarDetallepedido(detalle1Pedido2);

			DetallePedido detalle2Pedido2 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(6000.00)
					.build();
			pedido2.agregarDetallepedido(detalle2Pedido2);
			pedidoRepositorio.save(pedido2);




		};
	}


	}


