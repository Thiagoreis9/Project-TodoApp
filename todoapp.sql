-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 22-Jun-2022 às 15:51
-- Versão do servidor: 10.4.24-MariaDB
-- versão do PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `todoapp`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `projects`
--

CREATE TABLE `projects` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `createdAt` datetime DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `projects`
--

INSERT INTO `projects` (`id`, `name`, `description`, `createdAt`, `updatedAt`) VALUES
(1, 'Projeto teste', 'primeiro projeto de teste', '2022-06-21 00:00:00', '1900-01-22 00:00:00'),
(11, 'Projeto Thiago Reis', 'Projeto de teste no bd nova layout', '2022-06-13 00:00:00', '2022-06-13 00:00:00'),
(12, 'Projeto Funcional 1', 'Projeto funcional 1 descricao do projeto\n', '2022-06-13 00:00:00', '2022-06-13 00:00:00'),
(15, 'Mengao', 'Descricao do mengao\n', '2022-06-14 00:00:00', '2022-06-14 00:00:00'),
(20, 'Trilha Introdutoria', 'Trilha intodutoria do curso Capgemini Start.', '2022-06-17 00:00:00', '2022-06-17 00:00:00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tasks`
--

CREATE TABLE `tasks` (
  `id` int(11) NOT NULL,
  `idProject` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(225) DEFAULT NULL,
  `completed` tinyint(1) NOT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `deadline` date NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tasks`
--

INSERT INTO `tasks` (`id`, `idProject`, `name`, `description`, `completed`, `notes`, `deadline`, `createdAt`, `updatedAt`) VALUES
(1, 15, 'Primeira task teste', 'description da primeira task teste', 0, 'notas de teste da primeira task', '2022-06-17', '2022-06-17 00:00:00', '2022-06-17 00:00:00'),
(2, 11, 'Segunda Tarefa', 'Segunda Tarefa', 1, 'Segunda Tarefa', '2022-06-16', '2022-06-17 00:00:00', '2022-06-17 00:00:00'),
(20, 15, 'Terceira Task', 'Terceira task testando	', 0, 'terceira task testando', '2022-06-17', '2022-06-17 00:00:00', '2022-06-17 00:00:00'),
(21, 1, 'TaskTeste777', 'TaskTeste777TaskTeste777TaskTeste777', 1, 'TaskTeste777TaskTeste777TaskTeste777', '2022-06-22', '2022-06-17 00:00:00', '2022-06-17 00:00:00'),
(22, 11, 'Teste task projeto thiago', 'Teste task projeto thiago\nTeste task projeto thiago\nTeste task projeto thiago\nTeste task projeto thiago\n', 0, 'Teste task projeto thiago\nTeste task projeto thiago\nTeste task projeto thiago', '2022-06-28', '2022-06-17 00:00:00', '2022-06-17 00:00:00'),
(23, 1, 'tasktodoapp', 'tasktodoapp', 0, 'tasktodoapp', '2022-06-23', '2022-06-17 00:00:00', '2022-06-17 00:00:00'),
(24, 1, 'taskFunciona', 'taskFunciona', 1, 'taskFunciona', '2022-12-23', '2022-06-17 00:00:00', '2022-06-17 00:00:00');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `projects`
--
ALTER TABLE `projects`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tasks`
--
ALTER TABLE `tasks`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_projects` (`idProject`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `projects`
--
ALTER TABLE `projects`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de tabela `tasks`
--
ALTER TABLE `tasks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `tasks`
--
ALTER TABLE `tasks`
  ADD CONSTRAINT `fk_projects` FOREIGN KEY (`idProject`) REFERENCES `projects` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
