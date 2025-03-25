create table arquiteto (id integer not null auto_increment, nome varchar(255), tenant_id integer, primary key (id)) engine=InnoDB
create table classepermissao (id integer not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table cliente (id integer not null auto_increment, nome varchar(255), tenant_id integer, vendedor_id integer, primary key (id)) engine=InnoDB
create table codigo (id integer not null auto_increment, codigo varchar(255), telefone varchar(255), primary key (id)) engine=InnoDB
create table empresa (id integer not null auto_increment, bairro varchar(255), cep varchar(255), cidade varchar(255), complemento varchar(255), cpfoucnpj varchar(255), editar bit, email varchar(255), logradouro varchar(255), naturezapessoa varchar(255), nomecontato varchar(255), numero varchar(255), razaosocial varchar(255), status bit, telefone varchar(255), uf varchar(255), valor decimal(19,2), whats varchar(255), tenant_id integer, primary key (id)) engine=InnoDB
create table log_sistema (id integer not null auto_increment, comando varchar(255), datagravacao datetime, email_usuario varchar(255), status bit, arquiteto_id integer not null, cliente_id integer not null, empresa_id integer not null, pedido_id integer not null, permissao_id integer not null, produto_id integer not null, tenant_id integer, usuario_id integer not null, vendedor_id integer not null, primary key (id)) engine=InnoDB
create table pedido (id integer not null auto_increment, nf integer, cliente_id integer, produto_id integer, tenant_id integer, primary key (id)) engine=InnoDB
create table permissao (id integer not null auto_increment, descricao varchar(255), classepermissao_id integer, primary key (id)) engine=InnoDB
create table produto (id integer not null auto_increment, nome varchar(255), sku varchar(255), status bit, tenant_id integer, primary key (id)) engine=InnoDB
create table tenant (id integer not null auto_increment, descricao varchar(255), primary key (id)) engine=InnoDB
create table usuario (id integer not null auto_increment, email varchar(255), gtenantativo integer, login varchar(255), nome varchar(255), senha varchar(255), status bit, telefone varchar(255), tenantativo integer, tenant_id integer, primary key (id)) engine=InnoDB
create table usuario_permissao (id_usuario integer not null, id_permissao integer not null) engine=InnoDB
create table usuario_empresa (empresapadrao bit, tenant_id integer, id_empresa integer not null, id_usuario integer not null, primary key (id_empresa, id_usuario)) engine=InnoDB
create table vendedor (id integer not null auto_increment, nome varchar(255), arquiteto_id integer, tenant_id integer, primary key (id)) engine=InnoDB
alter table empresa add constraint UK_ow6ddx531a4abnwv6eah7h3k7 unique (cpfoucnpj)
alter table arquiteto add constraint FKewtqcjhvka8bh7wdunf83lh9j foreign key (tenant_id) references tenant (id)
alter table cliente add constraint FK2cmtkorj5frxna41x37pf0uco foreign key (tenant_id) references tenant (id)
alter table cliente add constraint FKhewilppvtrncti9mupmlppm61 foreign key (vendedor_id) references vendedor (id)
alter table empresa add constraint FKc94y9kg0tj2jd6u0jm6lfwv6h foreign key (tenant_id) references tenant (id)
alter table log_sistema add constraint FKluegn7r8mm1e84v9cxcbi1ic6 foreign key (arquiteto_id) references arquiteto (id)
alter table log_sistema add constraint FKte92hdwq58rux3207yj2qvx9v foreign key (cliente_id) references cliente (id)
alter table log_sistema add constraint FKdtxgdxwvuxbb45995iirr9ase foreign key (empresa_id) references empresa (id)
alter table log_sistema add constraint FKfxd8hmfe5f8baqkm2l88gyu08 foreign key (pedido_id) references pedido (id)
alter table log_sistema add constraint FKlu2agpnij2euws8475xbxj5pf foreign key (permissao_id) references permissao (id)
alter table log_sistema add constraint FKci3i8bv71ec8vkfgbjgwpjily foreign key (produto_id) references produto (id)
alter table log_sistema add constraint FK70ecb2jvl5xk791a9ybtw1dsv foreign key (tenant_id) references tenant (id)
alter table log_sistema add constraint FKsltyfd8mjygt5amoo95i5p9iw foreign key (usuario_id) references usuario (id)
alter table log_sistema add constraint FK7qm6c6ldgvqx3e97ij4kwj5wd foreign key (vendedor_id) references vendedor (id)
alter table pedido add constraint FK30s8j2ktpay6of18lbyqn3632 foreign key (cliente_id) references cliente (id)
alter table pedido add constraint FK73bw249kqpeedj11lmig00nj4 foreign key (produto_id) references produto (id)
alter table pedido add constraint FK180dwib6bmjcexaokknove0mr foreign key (tenant_id) references tenant (id)
alter table permissao add constraint FKdiyasfskbnh46lmx2ywloji0d foreign key (classepermissao_id) references classepermissao (id)
alter table produto add constraint FK9lpb3f1r5xbcc0fcex0ubs0i6 foreign key (tenant_id) references tenant (id)
alter table usuario add constraint FKa10giac3ef9545ra7eyhmn4q1 foreign key (tenant_id) references tenant (id)
alter table usuario_permissao add constraint FKjvcxjnrmdhdv6eti5d7svm5xw foreign key (id_permissao) references permissao (id)
alter table usuario_permissao add constraint FKbo8hww1whbpxq8ancjokhnfds foreign key (id_usuario) references usuario (id)
alter table usuario_empresa add constraint FKkicrvlg5cwo9w2xi83xrq4ver foreign key (id_empresa) references empresa (id)
alter table usuario_empresa add constraint FK62hh8xjf2yjsncl8ti6vxjm7h foreign key (id_usuario) references usuario (id)
alter table vendedor add constraint FKsph8qvhxt3299tm4pgr6x6heh foreign key (arquiteto_id) references arquiteto (id)
alter table vendedor add constraint FK1xqif4nhi3xjtmoeuflc3ooba foreign key (tenant_id) references tenant (id)
create table arquiteto (id integer not null auto_increment, nome varchar(255), tenant_id integer, primary key (id)) engine=InnoDB
create table classepermissao (id integer not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table cliente (id integer not null auto_increment, nome varchar(255), tenant_id integer, vendedor_id integer, primary key (id)) engine=InnoDB
create table codigo (id integer not null auto_increment, codigo varchar(255), telefone varchar(255), primary key (id)) engine=InnoDB
create table empresa (id integer not null auto_increment, bairro varchar(255), cep varchar(255), cidade varchar(255), complemento varchar(255), cpfoucnpj varchar(255), editar bit, email varchar(255), logradouro varchar(255), naturezapessoa varchar(255), nomecontato varchar(255), numero varchar(255), razaosocial varchar(255), status bit, telefone varchar(255), uf varchar(255), valor decimal(19,2), whats varchar(255), tenant_id integer, primary key (id)) engine=InnoDB
create table log_sistema (id integer not null auto_increment, comando varchar(255), datagravacao datetime, email_usuario varchar(255), status bit, arquiteto_id integer not null, cliente_id integer not null, empresa_id integer not null, pedido_id integer not null, permissao_id integer not null, produto_id integer not null, tenant_id integer, usuario_id integer not null, vendedor_id integer not null, primary key (id)) engine=InnoDB
create table pedido (id integer not null auto_increment, nf integer, cliente_id integer, produto_id integer, tenant_id integer, primary key (id)) engine=InnoDB
create table permissao (id integer not null auto_increment, descricao varchar(255), classepermissao_id integer, primary key (id)) engine=InnoDB
create table produto (id integer not null auto_increment, nome varchar(255), sku varchar(255), status bit, tenant_id integer, primary key (id)) engine=InnoDB
create table tenant (id integer not null auto_increment, descricao varchar(255), primary key (id)) engine=InnoDB
create table usuario (id integer not null auto_increment, email varchar(255), gtenantativo integer, login varchar(255), nome varchar(255), senha varchar(255), status bit, telefone varchar(255), tenantativo integer, tenant_id integer, primary key (id)) engine=InnoDB
create table usuario_permissao (id_usuario integer not null, id_permissao integer not null) engine=InnoDB
create table usuario_empresa (empresapadrao bit, tenant_id integer, id_empresa integer not null, id_usuario integer not null, primary key (id_empresa, id_usuario)) engine=InnoDB
create table vendedor (id integer not null auto_increment, nome varchar(255), arquiteto_id integer, tenant_id integer, primary key (id)) engine=InnoDB
alter table empresa add constraint UK_ow6ddx531a4abnwv6eah7h3k7 unique (cpfoucnpj)
alter table arquiteto add constraint FKewtqcjhvka8bh7wdunf83lh9j foreign key (tenant_id) references tenant (id)
alter table cliente add constraint FK2cmtkorj5frxna41x37pf0uco foreign key (tenant_id) references tenant (id)
alter table cliente add constraint FKhewilppvtrncti9mupmlppm61 foreign key (vendedor_id) references vendedor (id)
alter table empresa add constraint FKc94y9kg0tj2jd6u0jm6lfwv6h foreign key (tenant_id) references tenant (id)
alter table log_sistema add constraint FKluegn7r8mm1e84v9cxcbi1ic6 foreign key (arquiteto_id) references arquiteto (id)
alter table log_sistema add constraint FKte92hdwq58rux3207yj2qvx9v foreign key (cliente_id) references cliente (id)
alter table log_sistema add constraint FKdtxgdxwvuxbb45995iirr9ase foreign key (empresa_id) references empresa (id)
alter table log_sistema add constraint FKfxd8hmfe5f8baqkm2l88gyu08 foreign key (pedido_id) references pedido (id)
alter table log_sistema add constraint FKlu2agpnij2euws8475xbxj5pf foreign key (permissao_id) references permissao (id)
alter table log_sistema add constraint FKci3i8bv71ec8vkfgbjgwpjily foreign key (produto_id) references produto (id)
alter table log_sistema add constraint FK70ecb2jvl5xk791a9ybtw1dsv foreign key (tenant_id) references tenant (id)
alter table log_sistema add constraint FKsltyfd8mjygt5amoo95i5p9iw foreign key (usuario_id) references usuario (id)
alter table log_sistema add constraint FK7qm6c6ldgvqx3e97ij4kwj5wd foreign key (vendedor_id) references vendedor (id)
alter table pedido add constraint FK30s8j2ktpay6of18lbyqn3632 foreign key (cliente_id) references cliente (id)
alter table pedido add constraint FK73bw249kqpeedj11lmig00nj4 foreign key (produto_id) references produto (id)
alter table pedido add constraint FK180dwib6bmjcexaokknove0mr foreign key (tenant_id) references tenant (id)
alter table permissao add constraint FKdiyasfskbnh46lmx2ywloji0d foreign key (classepermissao_id) references classepermissao (id)
alter table produto add constraint FK9lpb3f1r5xbcc0fcex0ubs0i6 foreign key (tenant_id) references tenant (id)
alter table usuario add constraint FKa10giac3ef9545ra7eyhmn4q1 foreign key (tenant_id) references tenant (id)
alter table usuario_permissao add constraint FKjvcxjnrmdhdv6eti5d7svm5xw foreign key (id_permissao) references permissao (id)
alter table usuario_permissao add constraint FKbo8hww1whbpxq8ancjokhnfds foreign key (id_usuario) references usuario (id)
alter table usuario_empresa add constraint FKkicrvlg5cwo9w2xi83xrq4ver foreign key (id_empresa) references empresa (id)
alter table usuario_empresa add constraint FK62hh8xjf2yjsncl8ti6vxjm7h foreign key (id_usuario) references usuario (id)
alter table vendedor add constraint FKsph8qvhxt3299tm4pgr6x6heh foreign key (arquiteto_id) references arquiteto (id)
alter table vendedor add constraint FK1xqif4nhi3xjtmoeuflc3ooba foreign key (tenant_id) references tenant (id)
create table arquiteto (id integer not null auto_increment, nome varchar(255), tenant_id integer, primary key (id)) engine=InnoDB
create table classepermissao (id integer not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table cliente (id integer not null auto_increment, nome varchar(255), tenant_id integer, vendedor_id integer, primary key (id)) engine=InnoDB
create table codigo (id integer not null auto_increment, codigo varchar(255), telefone varchar(255), primary key (id)) engine=InnoDB
create table empresa (id integer not null auto_increment, bairro varchar(255), cep varchar(255), cidade varchar(255), complemento varchar(255), cpfoucnpj varchar(255), editar bit, email varchar(255), logradouro varchar(255), naturezapessoa varchar(255), nomecontato varchar(255), numero varchar(255), razaosocial varchar(255), status bit, telefone varchar(255), uf varchar(255), valor decimal(19,2), whats varchar(255), tenant_id integer, primary key (id)) engine=InnoDB
create table log_sistema (id integer not null auto_increment, comando varchar(255), datagravacao datetime, email_usuario varchar(255), status bit, arquiteto_id integer not null, cliente_id integer not null, empresa_id integer not null, pedido_id integer not null, permissao_id integer not null, produto_id integer not null, tenant_id integer, usuario_id integer not null, vendedor_id integer not null, primary key (id)) engine=InnoDB
create table pedido (id integer not null auto_increment, nf integer, cliente_id integer, produto_id integer, tenant_id integer, primary key (id)) engine=InnoDB
create table permissao (id integer not null auto_increment, descricao varchar(255), classepermissao_id integer, primary key (id)) engine=InnoDB
create table produto (id integer not null auto_increment, nome varchar(255), sku varchar(255), status bit, tenant_id integer, primary key (id)) engine=InnoDB
create table tenant (id integer not null auto_increment, descricao varchar(255), primary key (id)) engine=InnoDB
create table usuario (id integer not null auto_increment, email varchar(255), gtenantativo integer, login varchar(255), nome varchar(255), senha varchar(255), status bit, telefone varchar(255), tenantativo integer, tenant_id integer, primary key (id)) engine=InnoDB
create table usuario_permissao (id_usuario integer not null, id_permissao integer not null) engine=InnoDB
create table usuario_empresa (empresapadrao bit, tenant_id integer, id_empresa integer not null, id_usuario integer not null, primary key (id_empresa, id_usuario)) engine=InnoDB
create table vendedor (id integer not null auto_increment, nome varchar(255), arquiteto_id integer, tenant_id integer, primary key (id)) engine=InnoDB
alter table empresa add constraint UK_ow6ddx531a4abnwv6eah7h3k7 unique (cpfoucnpj)
alter table arquiteto add constraint FKewtqcjhvka8bh7wdunf83lh9j foreign key (tenant_id) references tenant (id)
alter table cliente add constraint FK2cmtkorj5frxna41x37pf0uco foreign key (tenant_id) references tenant (id)
alter table cliente add constraint FKhewilppvtrncti9mupmlppm61 foreign key (vendedor_id) references vendedor (id)
alter table empresa add constraint FKc94y9kg0tj2jd6u0jm6lfwv6h foreign key (tenant_id) references tenant (id)
alter table log_sistema add constraint FKluegn7r8mm1e84v9cxcbi1ic6 foreign key (arquiteto_id) references arquiteto (id)
alter table log_sistema add constraint FKte92hdwq58rux3207yj2qvx9v foreign key (cliente_id) references cliente (id)
alter table log_sistema add constraint FKdtxgdxwvuxbb45995iirr9ase foreign key (empresa_id) references empresa (id)
alter table log_sistema add constraint FKfxd8hmfe5f8baqkm2l88gyu08 foreign key (pedido_id) references pedido (id)
alter table log_sistema add constraint FKlu2agpnij2euws8475xbxj5pf foreign key (permissao_id) references permissao (id)
alter table log_sistema add constraint FKci3i8bv71ec8vkfgbjgwpjily foreign key (produto_id) references produto (id)
alter table log_sistema add constraint FK70ecb2jvl5xk791a9ybtw1dsv foreign key (tenant_id) references tenant (id)
alter table log_sistema add constraint FKsltyfd8mjygt5amoo95i5p9iw foreign key (usuario_id) references usuario (id)
alter table log_sistema add constraint FK7qm6c6ldgvqx3e97ij4kwj5wd foreign key (vendedor_id) references vendedor (id)
alter table pedido add constraint FK30s8j2ktpay6of18lbyqn3632 foreign key (cliente_id) references cliente (id)
alter table pedido add constraint FK73bw249kqpeedj11lmig00nj4 foreign key (produto_id) references produto (id)
alter table pedido add constraint FK180dwib6bmjcexaokknove0mr foreign key (tenant_id) references tenant (id)
alter table permissao add constraint FKdiyasfskbnh46lmx2ywloji0d foreign key (classepermissao_id) references classepermissao (id)
alter table produto add constraint FK9lpb3f1r5xbcc0fcex0ubs0i6 foreign key (tenant_id) references tenant (id)
alter table usuario add constraint FKa10giac3ef9545ra7eyhmn4q1 foreign key (tenant_id) references tenant (id)
alter table usuario_permissao add constraint FKjvcxjnrmdhdv6eti5d7svm5xw foreign key (id_permissao) references permissao (id)
alter table usuario_permissao add constraint FKbo8hww1whbpxq8ancjokhnfds foreign key (id_usuario) references usuario (id)
alter table usuario_empresa add constraint FKkicrvlg5cwo9w2xi83xrq4ver foreign key (id_empresa) references empresa (id)
alter table usuario_empresa add constraint FK62hh8xjf2yjsncl8ti6vxjm7h foreign key (id_usuario) references usuario (id)
alter table vendedor add constraint FKsph8qvhxt3299tm4pgr6x6heh foreign key (arquiteto_id) references arquiteto (id)
alter table vendedor add constraint FK1xqif4nhi3xjtmoeuflc3ooba foreign key (tenant_id) references tenant (id)
create table arquiteto (id integer not null auto_increment, nome varchar(255), tenant_id integer, primary key (id)) engine=InnoDB
create table classepermissao (id integer not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table cliente (id integer not null auto_increment, nome varchar(255), tenant_id integer, vendedor_id integer, primary key (id)) engine=InnoDB
create table codigo (id integer not null auto_increment, codigo varchar(255), telefone varchar(255), primary key (id)) engine=InnoDB
create table empresa (id integer not null auto_increment, bairro varchar(255), cep varchar(255), cidade varchar(255), complemento varchar(255), cpfoucnpj varchar(255), editar bit, email varchar(255), logradouro varchar(255), naturezapessoa varchar(255), nomecontato varchar(255), numero varchar(255), razaosocial varchar(255), status bit, telefone varchar(255), uf varchar(255), valor decimal(19,2), whats varchar(255), tenant_id integer, primary key (id)) engine=InnoDB
create table log_sistema (id integer not null auto_increment, comando varchar(255), datagravacao datetime, email_usuario varchar(255), status bit, arquiteto_id integer not null, cliente_id integer not null, empresa_id integer not null, pedido_id integer not null, permissao_id integer not null, produto_id integer not null, tenant_id integer, usuario_id integer not null, vendedor_id integer not null, primary key (id)) engine=InnoDB
create table pedido (id integer not null auto_increment, nf integer, cliente_id integer, produto_id integer, tenant_id integer, primary key (id)) engine=InnoDB
create table permissao (id integer not null auto_increment, descricao varchar(255), classepermissao_id integer, primary key (id)) engine=InnoDB
create table produto (id integer not null auto_increment, nome varchar(255), sku varchar(255), status bit, tenant_id integer, primary key (id)) engine=InnoDB
create table tenant (id integer not null auto_increment, descricao varchar(255), primary key (id)) engine=InnoDB
create table usuario (id integer not null auto_increment, email varchar(255), gtenantativo integer, login varchar(255), nome varchar(255), senha varchar(255), status bit, telefone varchar(255), tenantativo integer, tenant_id integer, primary key (id)) engine=InnoDB
create table usuario_permissao (id_usuario integer not null, id_permissao integer not null) engine=InnoDB
create table usuario_empresa (empresapadrao bit, tenant_id integer, id_empresa integer not null, id_usuario integer not null, primary key (id_empresa, id_usuario)) engine=InnoDB
create table vendedor (id integer not null auto_increment, nome varchar(255), arquiteto_id integer, tenant_id integer, primary key (id)) engine=InnoDB
alter table empresa add constraint UK_ow6ddx531a4abnwv6eah7h3k7 unique (cpfoucnpj)
alter table arquiteto add constraint FKewtqcjhvka8bh7wdunf83lh9j foreign key (tenant_id) references tenant (id)
alter table cliente add constraint FK2cmtkorj5frxna41x37pf0uco foreign key (tenant_id) references tenant (id)
alter table cliente add constraint FKhewilppvtrncti9mupmlppm61 foreign key (vendedor_id) references vendedor (id)
alter table empresa add constraint FKc94y9kg0tj2jd6u0jm6lfwv6h foreign key (tenant_id) references tenant (id)
alter table log_sistema add constraint FKluegn7r8mm1e84v9cxcbi1ic6 foreign key (arquiteto_id) references arquiteto (id)
alter table log_sistema add constraint FKte92hdwq58rux3207yj2qvx9v foreign key (cliente_id) references cliente (id)
alter table log_sistema add constraint FKdtxgdxwvuxbb45995iirr9ase foreign key (empresa_id) references empresa (id)
alter table log_sistema add constraint FKfxd8hmfe5f8baqkm2l88gyu08 foreign key (pedido_id) references pedido (id)
alter table log_sistema add constraint FKlu2agpnij2euws8475xbxj5pf foreign key (permissao_id) references permissao (id)
alter table log_sistema add constraint FKci3i8bv71ec8vkfgbjgwpjily foreign key (produto_id) references produto (id)
alter table log_sistema add constraint FK70ecb2jvl5xk791a9ybtw1dsv foreign key (tenant_id) references tenant (id)
alter table log_sistema add constraint FKsltyfd8mjygt5amoo95i5p9iw foreign key (usuario_id) references usuario (id)
alter table log_sistema add constraint FK7qm6c6ldgvqx3e97ij4kwj5wd foreign key (vendedor_id) references vendedor (id)
alter table pedido add constraint FK30s8j2ktpay6of18lbyqn3632 foreign key (cliente_id) references cliente (id)
alter table pedido add constraint FK73bw249kqpeedj11lmig00nj4 foreign key (produto_id) references produto (id)
alter table pedido add constraint FK180dwib6bmjcexaokknove0mr foreign key (tenant_id) references tenant (id)
alter table permissao add constraint FKdiyasfskbnh46lmx2ywloji0d foreign key (classepermissao_id) references classepermissao (id)
alter table produto add constraint FK9lpb3f1r5xbcc0fcex0ubs0i6 foreign key (tenant_id) references tenant (id)
alter table usuario add constraint FKa10giac3ef9545ra7eyhmn4q1 foreign key (tenant_id) references tenant (id)
alter table usuario_permissao add constraint FKjvcxjnrmdhdv6eti5d7svm5xw foreign key (id_permissao) references permissao (id)
alter table usuario_permissao add constraint FKbo8hww1whbpxq8ancjokhnfds foreign key (id_usuario) references usuario (id)
alter table usuario_empresa add constraint FKkicrvlg5cwo9w2xi83xrq4ver foreign key (id_empresa) references empresa (id)
alter table usuario_empresa add constraint FK62hh8xjf2yjsncl8ti6vxjm7h foreign key (id_usuario) references usuario (id)
alter table vendedor add constraint FKsph8qvhxt3299tm4pgr6x6heh foreign key (arquiteto_id) references arquiteto (id)
alter table vendedor add constraint FK1xqif4nhi3xjtmoeuflc3ooba foreign key (tenant_id) references tenant (id)
create table arquiteto (id integer not null auto_increment, nome varchar(255), tenant_id integer, primary key (id)) engine=InnoDB
create table classepermissao (id integer not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table cliente (id integer not null auto_increment, nome varchar(255), tenant_id integer, vendedor_id integer, primary key (id)) engine=InnoDB
create table codigo (id integer not null auto_increment, codigo varchar(255), telefone varchar(255), primary key (id)) engine=InnoDB
create table empresa (id integer not null auto_increment, bairro varchar(255), cep varchar(255), cidade varchar(255), complemento varchar(255), cpfoucnpj varchar(255), editar bit, email varchar(255), logradouro varchar(255), naturezapessoa varchar(255), nomecontato varchar(255), numero varchar(255), razaosocial varchar(255), status bit, telefone varchar(255), uf varchar(255), valor decimal(19,2), whats varchar(255), tenant_id integer, primary key (id)) engine=InnoDB
create table log_sistema (id integer not null auto_increment, comando varchar(255), datagravacao datetime, email_usuario varchar(255), status bit, arquiteto_id integer not null, cliente_id integer not null, empresa_id integer not null, pedido_id integer not null, permissao_id integer not null, produto_id integer not null, tenant_id integer, usuario_id integer not null, vendedor_id integer not null, primary key (id)) engine=InnoDB
create table pedido (id integer not null auto_increment, nf integer, cliente_id integer, produto_id integer, tenant_id integer, primary key (id)) engine=InnoDB
create table permissao (id integer not null auto_increment, descricao varchar(255), classepermissao_id integer, primary key (id)) engine=InnoDB
create table produto (id integer not null auto_increment, nome varchar(255), sku varchar(255), status bit, tenant_id integer, primary key (id)) engine=InnoDB
create table tenant (id integer not null auto_increment, descricao varchar(255), primary key (id)) engine=InnoDB
create table usuario (id integer not null auto_increment, email varchar(255), gtenantativo integer, login varchar(255), nome varchar(255), senha varchar(255), status bit, telefone varchar(255), tenantativo integer, tenant_id integer, primary key (id)) engine=InnoDB
create table usuario_permissao (id_usuario integer not null, id_permissao integer not null) engine=InnoDB
create table usuario_empresa (empresapadrao bit, tenant_id integer, id_empresa integer not null, id_usuario integer not null, primary key (id_empresa, id_usuario)) engine=InnoDB
create table vendedor (id integer not null auto_increment, nome varchar(255), arquiteto_id integer, tenant_id integer, primary key (id)) engine=InnoDB
alter table empresa add constraint UK_ow6ddx531a4abnwv6eah7h3k7 unique (cpfoucnpj)
alter table arquiteto add constraint FKewtqcjhvka8bh7wdunf83lh9j foreign key (tenant_id) references tenant (id)
alter table cliente add constraint FK2cmtkorj5frxna41x37pf0uco foreign key (tenant_id) references tenant (id)
alter table cliente add constraint FKhewilppvtrncti9mupmlppm61 foreign key (vendedor_id) references vendedor (id)
alter table empresa add constraint FKc94y9kg0tj2jd6u0jm6lfwv6h foreign key (tenant_id) references tenant (id)
alter table log_sistema add constraint FKluegn7r8mm1e84v9cxcbi1ic6 foreign key (arquiteto_id) references arquiteto (id)
alter table log_sistema add constraint FKte92hdwq58rux3207yj2qvx9v foreign key (cliente_id) references cliente (id)
alter table log_sistema add constraint FKdtxgdxwvuxbb45995iirr9ase foreign key (empresa_id) references empresa (id)
alter table log_sistema add constraint FKfxd8hmfe5f8baqkm2l88gyu08 foreign key (pedido_id) references pedido (id)
alter table log_sistema add constraint FKlu2agpnij2euws8475xbxj5pf foreign key (permissao_id) references permissao (id)
alter table log_sistema add constraint FKci3i8bv71ec8vkfgbjgwpjily foreign key (produto_id) references produto (id)
alter table log_sistema add constraint FK70ecb2jvl5xk791a9ybtw1dsv foreign key (tenant_id) references tenant (id)
alter table log_sistema add constraint FKsltyfd8mjygt5amoo95i5p9iw foreign key (usuario_id) references usuario (id)
alter table log_sistema add constraint FK7qm6c6ldgvqx3e97ij4kwj5wd foreign key (vendedor_id) references vendedor (id)
alter table pedido add constraint FK30s8j2ktpay6of18lbyqn3632 foreign key (cliente_id) references cliente (id)
alter table pedido add constraint FK73bw249kqpeedj11lmig00nj4 foreign key (produto_id) references produto (id)
alter table pedido add constraint FK180dwib6bmjcexaokknove0mr foreign key (tenant_id) references tenant (id)
alter table permissao add constraint FKdiyasfskbnh46lmx2ywloji0d foreign key (classepermissao_id) references classepermissao (id)
alter table produto add constraint FK9lpb3f1r5xbcc0fcex0ubs0i6 foreign key (tenant_id) references tenant (id)
alter table usuario add constraint FKa10giac3ef9545ra7eyhmn4q1 foreign key (tenant_id) references tenant (id)
alter table usuario_permissao add constraint FKjvcxjnrmdhdv6eti5d7svm5xw foreign key (id_permissao) references permissao (id)
alter table usuario_permissao add constraint FKbo8hww1whbpxq8ancjokhnfds foreign key (id_usuario) references usuario (id)
alter table usuario_empresa add constraint FKkicrvlg5cwo9w2xi83xrq4ver foreign key (id_empresa) references empresa (id)
alter table usuario_empresa add constraint FK62hh8xjf2yjsncl8ti6vxjm7h foreign key (id_usuario) references usuario (id)
alter table vendedor add constraint FKsph8qvhxt3299tm4pgr6x6heh foreign key (arquiteto_id) references arquiteto (id)
alter table vendedor add constraint FK1xqif4nhi3xjtmoeuflc3ooba foreign key (tenant_id) references tenant (id)
create table arquiteto (id integer not null auto_increment, nome varchar(255), tenant_id integer, primary key (id)) engine=InnoDB
create table classepermissao (id integer not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB
create table cliente (id integer not null auto_increment, nome varchar(255), tenant_id integer, vendedor_id integer, primary key (id)) engine=InnoDB
create table codigo (id integer not null auto_increment, codigo varchar(255), telefone varchar(255), primary key (id)) engine=InnoDB
create table empresa (id integer not null auto_increment, bairro varchar(255), cep varchar(255), cidade varchar(255), complemento varchar(255), cpfoucnpj varchar(255), editar bit, email varchar(255), logradouro varchar(255), naturezapessoa varchar(255), nomecontato varchar(255), numero varchar(255), razaosocial varchar(255), status bit, telefone varchar(255), uf varchar(255), valor decimal(19,2), whats varchar(255), tenant_id integer, primary key (id)) engine=InnoDB
create table log_sistema (id integer not null auto_increment, comando varchar(255), datagravacao datetime, email_usuario varchar(255), status bit, arquiteto_id integer not null, cliente_id integer not null, empresa_id integer not null, pedido_id integer not null, permissao_id integer not null, produto_id integer not null, tenant_id integer, usuario_id integer not null, vendedor_id integer not null, primary key (id)) engine=InnoDB
create table pedido (id integer not null auto_increment, nf integer, cliente_id integer, produto_id integer, tenant_id integer, primary key (id)) engine=InnoDB
create table permissao (id integer not null auto_increment, descricao varchar(255), classepermissao_id integer, primary key (id)) engine=InnoDB
create table produto (id integer not null auto_increment, nome varchar(255), sku varchar(255), status bit, tenant_id integer, primary key (id)) engine=InnoDB
create table tenant (id integer not null auto_increment, descricao varchar(255), primary key (id)) engine=InnoDB
create table usuario (id integer not null auto_increment, email varchar(255), gtenantativo integer, login varchar(255), nome varchar(255), senha varchar(255), status bit, telefone varchar(255), tenantativo integer, tenant_id integer, primary key (id)) engine=InnoDB
create table usuario_permissao (id_usuario integer not null, id_permissao integer not null) engine=InnoDB
create table usuario_empresa (empresapadrao bit, tenant_id integer, id_empresa integer not null, id_usuario integer not null, primary key (id_empresa, id_usuario)) engine=InnoDB
create table vendedor (id integer not null auto_increment, nome varchar(255), arquiteto_id integer, tenant_id integer, primary key (id)) engine=InnoDB
alter table empresa add constraint UK_ow6ddx531a4abnwv6eah7h3k7 unique (cpfoucnpj)
alter table arquiteto add constraint FKewtqcjhvka8bh7wdunf83lh9j foreign key (tenant_id) references tenant (id)
alter table cliente add constraint FK2cmtkorj5frxna41x37pf0uco foreign key (tenant_id) references tenant (id)
alter table cliente add constraint FKhewilppvtrncti9mupmlppm61 foreign key (vendedor_id) references vendedor (id)
alter table empresa add constraint FKc94y9kg0tj2jd6u0jm6lfwv6h foreign key (tenant_id) references tenant (id)
alter table log_sistema add constraint FKluegn7r8mm1e84v9cxcbi1ic6 foreign key (arquiteto_id) references arquiteto (id)
alter table log_sistema add constraint FKte92hdwq58rux3207yj2qvx9v foreign key (cliente_id) references cliente (id)
alter table log_sistema add constraint FKdtxgdxwvuxbb45995iirr9ase foreign key (empresa_id) references empresa (id)
alter table log_sistema add constraint FKfxd8hmfe5f8baqkm2l88gyu08 foreign key (pedido_id) references pedido (id)
alter table log_sistema add constraint FKlu2agpnij2euws8475xbxj5pf foreign key (permissao_id) references permissao (id)
alter table log_sistema add constraint FKci3i8bv71ec8vkfgbjgwpjily foreign key (produto_id) references produto (id)
alter table log_sistema add constraint FK70ecb2jvl5xk791a9ybtw1dsv foreign key (tenant_id) references tenant (id)
alter table log_sistema add constraint FKsltyfd8mjygt5amoo95i5p9iw foreign key (usuario_id) references usuario (id)
alter table log_sistema add constraint FK7qm6c6ldgvqx3e97ij4kwj5wd foreign key (vendedor_id) references vendedor (id)
alter table pedido add constraint FK30s8j2ktpay6of18lbyqn3632 foreign key (cliente_id) references cliente (id)
alter table pedido add constraint FK73bw249kqpeedj11lmig00nj4 foreign key (produto_id) references produto (id)
alter table pedido add constraint FK180dwib6bmjcexaokknove0mr foreign key (tenant_id) references tenant (id)
alter table permissao add constraint FKdiyasfskbnh46lmx2ywloji0d foreign key (classepermissao_id) references classepermissao (id)
alter table produto add constraint FK9lpb3f1r5xbcc0fcex0ubs0i6 foreign key (tenant_id) references tenant (id)
alter table usuario add constraint FKa10giac3ef9545ra7eyhmn4q1 foreign key (tenant_id) references tenant (id)
alter table usuario_permissao add constraint FKjvcxjnrmdhdv6eti5d7svm5xw foreign key (id_permissao) references permissao (id)
alter table usuario_permissao add constraint FKbo8hww1whbpxq8ancjokhnfds foreign key (id_usuario) references usuario (id)
alter table usuario_empresa add constraint FKkicrvlg5cwo9w2xi83xrq4ver foreign key (id_empresa) references empresa (id)
alter table usuario_empresa add constraint FK62hh8xjf2yjsncl8ti6vxjm7h foreign key (id_usuario) references usuario (id)
alter table vendedor add constraint FKsph8qvhxt3299tm4pgr6x6heh foreign key (arquiteto_id) references arquiteto (id)
alter table vendedor add constraint FK1xqif4nhi3xjtmoeuflc3ooba foreign key (tenant_id) references tenant (id)
